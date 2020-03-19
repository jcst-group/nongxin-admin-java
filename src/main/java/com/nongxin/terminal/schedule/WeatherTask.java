package com.nongxin.terminal.schedule;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.dao.address.AreaMapper;
import com.nongxin.terminal.dao.weather.*;
import com.nongxin.terminal.entity.weather.*;
import com.nongxin.terminal.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Configuration
@EnableScheduling
public class WeatherTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherTask.class);

    @Autowired
    private WeatherRealMapper weatherRealMapper;

    @Autowired
    private WeatherForecastMapper weatherForecastMapper;

    @Autowired
    private WeatherHistoryMapper weatherHistoryMapper;

    @Autowired
    private WeatherAreaMapper weatherAreaMapper;

    @Autowired
    private WeatherHourMapper weatherHourMapper;

    @Autowired
    private AreaMapper areaMapper;

    /**
     * 实时天气
     */
    @Scheduled(cron = "0 0,30 * * * ?")
    public void now(){

        List<WeatherArea> areaList = weatherAreaMapper.getList();
        if(areaList!=null) {
            for (int i = 0; i < areaList.size(); i++) {
                JSONObject result =JSONObject.parseObject(this.fetch("/area-to-weather",areaList.get(i).getAreaName()));
                JSONObject res_body = JSONObject.parseObject(result.getString("showapi_res_body"));
                JSONObject now = JSONObject.parseObject(res_body.getString("now"));
                JSONObject aqi = JSONObject.parseObject(now.getString("aqiDetail"));
                JSONObject cityInfo = JSONObject.parseObject(res_body.getString("cityInfo"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date monitorTime = datecovert(now.getString("temperature_time"),"yyyy-MM-dd");
                String areaCode= areaMapper.getAreaCode(cityInfo.getString("c3"));
                if(weatherRealMapper.selectByTimeAndAreaCode(simpleDateFormat.format(monitorTime),areaCode) ==null){
                    WeatherReal weatherReal = new WeatherReal();
                    weatherReal.setMonitorTime(monitorTime);
                    weatherReal.setAirTem(getBigDecimalData(now, "temperature"));
                    weatherReal.setAirHum(now.getString("sd"));
                    weatherReal.setAqi(now.getFloat("aqi"));
                    weatherReal.setWindDirection(now.getString("wind_direction"));
                    weatherReal.setWindPower(now.getString("wind_power"));
                    weatherReal.setCo(getBigDecimalData(aqi, "co"));
                    weatherReal.setNo2(getBigDecimalData(aqi, "no2"));
                    weatherReal.setO3(getBigDecimalData(aqi, "o3"));
                    weatherReal.setPm10(getBigDecimalData(aqi, "pm10"));
                    weatherReal.setPm25(getBigDecimalData(aqi, "pm2_5"));
                    weatherReal.setSo2(getBigDecimalData(aqi, "so2"));
                    weatherReal.setWeather(now.getString("weather"));
                    weatherReal.setWeatherCode(now.getString("weather_code"));
                    weatherReal.setAreaCode(areaCode);
                    weatherRealMapper.insertSelective(weatherReal);
                }
            }
        }
    }

    /**
     *  预报天气
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void forecast() throws ParseException {
        List<WeatherArea> areaList = weatherAreaMapper.getList();
        if(areaList!=null) {
            for (int i = 0; i < areaList.size(); i++) {
                JSONObject result = JSONObject.parseObject(this.fetch("/area-to-weather",areaList.get(i).getAreaName()));
                JSONObject res_body = JSONObject.parseObject(result.getString("showapi_res_body"));
                JSONObject cityInfo = JSONObject.parseObject(res_body.getString("cityInfo"));
                String areaCode = areaMapper.getAreaCode(cityInfo.getString("c3"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
                String[] s1={"f1","f2","f3","f4","f5","f6","f7"};
                for(int k = 0;k<s1.length;k++){
                    JSONObject f1 = JSONObject.parseObject(res_body.getString(s1[k]));
                    if(weatherForecastMapper.selectByDayAndAreaCode(simpleDateFormat.parse(f1.getString("day")),areaCode) ==null){
                        WeatherForecast weatherForecast = new WeatherForecast();
                        weatherForecast.setAirPress(getNumber(f1.getString("air_press")));
                        weatherForecast.setDayAirTemperature(getBigDecimalData(f1, "day_air_temperature"));
                        weatherForecast.setDayWeather(f1.getString("day_weather"));
                        weatherForecast.setNightAirTemperature(getBigDecimalData(f1, "night_air_temperature"));
                        weatherForecast.setNightWeather(f1.getString("night_weather"));
                        weatherForecast.setDayWindDirection(f1.getString("day_wind_direction"));
                        weatherForecast.setDayWindPower(f1.getString("day_wind_power"));
                        weatherForecast.setJiangshui(f1.getString("jiangshui"));
                        weatherForecast.setNightWindDirection(f1.getString("night_wind_direction"));
                        weatherForecast.setNightWindPower(f1.getString("night_wind_power"));
                        weatherForecast.setSunBeginEnd(f1.getString("sun_begin_end"));
                        weatherForecast.setDay(simpleDateFormat.parse(f1.getString("day")));
                        weatherForecast.setAreaCode(areaCode);
                        weatherForecastMapper.insertSelective(weatherForecast);
                    }
                }
            }
        }
    }

    /**
     * 历史天气
     */
//    @Scheduled(cron = "0 * 1 * * ?")
    public void history(){
        List<WeatherArea> areaList = weatherAreaMapper.getList();
        if(areaList!=null){
            for(int i=0;i<areaList.size();i++){
                JSONObject result = JSONObject.parseObject(this.fetch("/weatherhistory",areaList.get(i).getAreaName()));
                JSONObject res_body = JSONObject.parseObject(result.getString("showapi_res_body"));
                JSONArray list = JSONArray.parseArray(res_body.getString("list"));
                String areaCode = areaMapper.getAreaCode(res_body.getString("area"));
                for(int j=0;j<list.size();j++){
                    JSONObject data = list.getJSONObject(j);
                    WeatherHistory weatherHistory = new WeatherHistory();
                    if(weatherHistoryMapper.selectByDayAndCode(data.getString("time"),areaCode)==null){
                        weatherHistory.setAqi(data.getFloat("aqi"));
                        weatherHistory.setMaxTemperature(getBigDecimalData(data,"max_temperature"));
                        weatherHistory.setMinTemperature(getBigDecimalData(data,"min_temperature"));
                        weatherHistory.setWindDirection(data.getString("wind_direction"));
                        weatherHistory.setWindPower(data.getString("wind_power"));
                        weatherHistory.setDay(data.getString("time"));
                        weatherHistory.setAreaCode(areaCode);
                        weatherHistoryMapper.insertSelective(weatherHistory);
                    }
                }
            }
        }
    }

    /**
     * 抓取24小时天气预报
     */
    @Scheduled(cron = "0 0 * * * ?")
    public void hour() throws ParseException {
        List<WeatherArea> areaList = weatherAreaMapper.getList();
        if(areaList!=null) {
            for (int i = 0; i < areaList.size(); i++) {
                JSONObject result = JSONObject.parseObject(this.fetch("/hour24", areaList.get(i).getAreaName()));
                JSONObject res_body = JSONObject.parseObject(result.getString("showapi_res_body"));
                JSONArray hourList = JSONArray.parseArray(res_body.getString("hourList"));
                String areaCode = areaMapper.getAreaCode(res_body.getString("area"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
                for (int j = 0; j < hourList.size(); j++) {
                    JSONObject data = hourList.getJSONObject(j);
                    WeatherHour weatherHour = new WeatherHour();
                    weatherHour.setWeatherCode(data.getString("weather_code"));
                    weatherHour.setWindDirection(data.getString("wind_direction"));
                    weatherHour.setWindPower(data.getString("wind_power"));
                    weatherHour.setWeather(data.getString("weather"));
                    weatherHour.setTemperature(data.getString("temperature"));
                    Date time = simpleDateFormat.parse(data.getString("time"));
                    weatherHour.setTime(time);
                    weatherHour.setAreaCode(areaCode);
                    if(weatherHourMapper.selectByTimeAndCode(time,areaCode) == null){
                        weatherHourMapper.insertSelective(weatherHour);
                    }
                }
            }
        }
    }

    public String fetch(String location,String areaName) {
        String result = "";
        String host = "https://ali-weather.showapi.com";
        String path = location;
        String method = "GET";
        String appcode = "912f4ba38a394870aed1d60aca9a34fb";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("area",areaName);
        querys.put("month", "201910");
        querys.put("needMoreDay","1");
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public BigDecimal getBigDecimalData(JSONObject item, String key){
        BigDecimal data = null;
        try {
            data = item.getBigDecimal(key);
        } catch (Exception e) {
        }
        return data;
    }

    //截取数字
    public BigDecimal getNumber(String str){
        str=str.trim();
        String str2="";
        if(str != null && !"".equals(str)) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
                    str2 += str.charAt(i);
                }
            }
        }
        return new BigDecimal(str2);
    }

    //日期转换
    public Date datecovert(String monitorTime,String pattern){
        String strDate= monitorTime;
        //注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("HH:mm");
        SimpleDateFormat day = new SimpleDateFormat(pattern);
        String time = day.format(new Date())+" "+strDate;
        Date currtime = new Date();
        //必须捕获异常
        try {
            currtime  = simpleDateFormat.parse(time);
        } catch(ParseException px) {
            px.printStackTrace();
        }
        return currtime;
    }
}
