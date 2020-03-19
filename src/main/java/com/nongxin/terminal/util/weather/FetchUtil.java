package com.nongxin.terminal.util.weather;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.dao.address.AreaMapper;
import com.nongxin.terminal.dao.weather.WeatherForecastMapper;
import com.nongxin.terminal.dao.weather.WeatherHourMapper;
import com.nongxin.terminal.dao.weather.WeatherRealMapper;
import com.nongxin.terminal.entity.weather.WeatherForecast;
import com.nongxin.terminal.entity.weather.WeatherHour;
import com.nongxin.terminal.entity.weather.WeatherReal;
import com.nongxin.terminal.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class FetchUtil {

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private WeatherRealMapper weatherRealMapper;

    @Autowired
    private WeatherHourMapper weatherHourMapper;

    @Autowired
    private WeatherForecastMapper weatherForecastMapper;

    //所选城市无数据时，从阿里云抓取
    public void now(String areaName){
        JSONObject result = JSONObject.parseObject(this.fetch("/area-to-weather", areaName));
        JSONObject res_body = JSONObject.parseObject(result.getString("showapi_res_body"));
        JSONObject now = JSONObject.parseObject(res_body.getString("now"));
        JSONObject aqi = JSONObject.parseObject(now.getString("aqiDetail"));
        JSONObject cityInfo = JSONObject.parseObject(res_body.getString("cityInfo"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date monitorTime = datecovert(now.getString("temperature_time"), "yyyy-MM-dd");
        String areaCode = areaMapper.getAreaCode(cityInfo.getString("c3"));
        if(areaName.equals("西安")){
            areaCode = "610100";
        }
        if (weatherRealMapper.selectByTimeAndAreaCode(simpleDateFormat.format(monitorTime), areaCode) == null) {
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

    public void weatherHour(String areaName) throws ParseException {
        JSONObject result = JSONObject.parseObject(this.fetch("/hour24", areaName));
        JSONObject res_body = JSONObject.parseObject(result.getString("showapi_res_body"));
        JSONArray hourList = JSONArray.parseArray(res_body.getString("hourList"));
        String areaCode = areaMapper.getAreaCode(res_body.getString("area"));
        if(areaName.equals("西安")){
            areaCode = "610100";
        }
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

    //7天天气数据
    public void weatherDay(String areaName) throws ParseException {
        JSONObject result = JSONObject.parseObject(this.fetch("/area-to-weather",areaName));
        JSONObject res_body = JSONObject.parseObject(result.getString("showapi_res_body"));
        JSONObject cityInfo = JSONObject.parseObject(res_body.getString("cityInfo"));
        String areaCode = areaMapper.getAreaCode(cityInfo.getString("c3"));
        if(areaName.equals("西安")){
            areaCode = "610100";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String[] s1={"f1","f2","f3","f4","f5","f6","f7"};
        for(int k = 0;k<s1.length;k++){
            JSONObject f1 = JSONObject.parseObject(res_body.getString(s1[k]));
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
            if(weatherForecastMapper.selectByDayAndAreaCode(simpleDateFormat.parse(f1.getString("day")),areaCode) ==null){
                weatherForecastMapper.insertSelective(weatherForecast);
            }

        }
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


    public BigDecimal getBigDecimalData(JSONObject item, String key){
        BigDecimal data = null;
        try {
            data = item.getBigDecimal(key);
        } catch (Exception e) {
        }
        return data;
    }
}
