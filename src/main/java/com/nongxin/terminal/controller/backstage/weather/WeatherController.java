package com.nongxin.terminal.controller.backstage.weather;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.entity.weather.WeatherHour;
import com.nongxin.terminal.service.common.AreaService;
import com.nongxin.terminal.service.weather.WeatherHourService;
import com.nongxin.terminal.util.HttpUtils;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.constant.CommonConstant;
import com.nongxin.terminal.vo.weather.WeatherVo;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherHourService weatherHourService;

    @Autowired
    private AreaService areaService;

    @GetMapping("/getWeather")
    @ApiOperation(value = "获取当前地区未来24小时的天气状况")
    public Result<List<WeatherHour>> getWeather(String areaCode){
        Result<List<WeatherHour>> result = new Result<>();
        result.setSuccessResult(weatherHourService.getWeather(areaCode));
        return result;
    }

    @GetMapping("/getWeatherArea")
    @ApiOperation(value = "获取当前地区天气状况")
    public Result<WeatherVo> getWeatherArea(@RequestParam(defaultValue = "梅江") String areaName){
        Result<WeatherVo> result = new Result<>();
        result.setSuccessResult(weatherHourService.getWeatherByArea(areaName,"3"));
        return result;
    }

    @GetMapping("/getMzArea")
    @ApiOperation(value = "")
    public Result<List<String>> getMZArea(){
        Result<List<String>> result = new Result<>();
        result.setSuccessResult(areaService.getMzArea());
        return result;
    }

    @GetMapping("/getWeatherLog")
    @ApiOperation(value = "根据经纬度查询天气")
    public Result<WeatherVo> getWeatherArea(){
        Result<WeatherVo> result = new Result<>();
        String point = this.getPoint();
        JSONObject pointJson = JSONObject.parseObject(point);
        String x = pointJson.getString("x");
        String y = pointJson.getString("y");
        System.out.println(x+y);
        System.out.println(this.fetch(x,y));
        return result;
    }

    public String fetch(String x,String y) {
        String result = "";
        String host = "https://ali-weather.showapi.com";
        String path = "/gps-to-weather";
        String method = "GET";
        String appcode = "912f4ba38a394870aed1d60aca9a34fb";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("from", "5");
        querys.put("lat", y);
        querys.put("lng", x);
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            //获取response的body
            result = EntityUtils.toString(response.getEntity());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public String getPoint(){

            CloseableHttpResponse response = null;
            // 获取默认的请求客户端
            CloseableHttpClient client = HttpClients.createDefault();
            // 通过HttpPost来发送post请求
            HttpPost httpPost = new HttpPost("https://api.map.baidu.com/location/ip?ak=HQi0eHpVOLlRuIFlsTZNGlYvqLO56un3&coor=bd09ll");
            // 添加参数
            List<NameValuePair> list = new ArrayList<>();
            try {
                UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(list);
                formEntity.setContentType("application/json");
                // 第一步：通过setEntity 将我们的entity对象传递过去
                httpPost.setEntity(formEntity);
                response = client.execute(httpPost);
                String result = EntityUtils.toString(response.getEntity());
                JSONObject json =JSONObject.parseObject(result);
                JSONObject content = (JSONObject) JSONObject.parse(json.getString("content"));
                JSONObject point = (JSONObject) JSONObject.parse(content.getString("point"));
                return point.toJSONString();
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }finally {
                if (response != null){
                    try {
                        response.close();
                    }catch (Exception e){}
                }
            }
    }
}
