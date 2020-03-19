package com.nongxin.terminal.controller.app.weather;

import com.nongxin.terminal.dao.weather.WeatherAreaMapper;
import com.nongxin.terminal.entity.address.Area;
import com.nongxin.terminal.entity.weather.WeatherArea;
import com.nongxin.terminal.service.common.AreaService;
import com.nongxin.terminal.service.weather.WeatherHourService;
import com.nongxin.terminal.util.weather.FetchUtil;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.weather.AreaNameVo;
import com.nongxin.terminal.vo.weather.WeatherVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * App天气模块接口
 */
@RestController
@RequestMapping("/app/weather")
public class AppWeatherController {

    @Autowired
    private WeatherHourService weatherHourService;

    @Autowired
    private AreaService areaService;

    @Autowired
    private FetchUtil fetchUtil;

    @Autowired
    private WeatherAreaMapper weatherAreaMapper;

    @GetMapping("/getWeatherArea")
    @ApiOperation(value = "获取当前地区天气状况")
    public Result<WeatherVo> getWeatherArea(String areaName,String areaCode,String areaLevel) throws Exception {
        Result<WeatherVo> result = new Result<>();
        WeatherVo weatherVo = new WeatherVo();

        if(areaName!=null){   //根据城市名查询
            if(areaName.equals("北京")||areaName.equals("上海")||areaName.equals("重庆")||areaName.equals("天津")){
                areaLevel = "1";
            }
            weatherVo = weatherHourService.getWeatherByArea(areaName,areaLevel);
            if(weatherAreaMapper.selectByAreaName(areaName)==null){
                WeatherArea weatherArea = new WeatherArea();
                weatherArea.setAreaName(areaName);
                weatherAreaMapper.insertSelective(weatherArea);
            }
            result.setResult(weatherVo);
            result.setSuccess(true);
        }else{
            weatherVo = weatherHourService.getWeatherByCode(areaCode);
            result.setResult(weatherVo);
            result.setSuccess(true);
        }
        if(weatherVo.getNow()==null&&areaName!=null){
            fetchUtil.now(areaName);
            fetchUtil.weatherHour(areaName);
            fetchUtil.weatherDay(areaName);
            TimeUnit.SECONDS.sleep(1);
            WeatherVo weatherVo1 = weatherHourService.getWeatherByArea(areaName,areaLevel);
            result.setResult(weatherVo1);
            result.setSuccess(true);
        }else if(weatherVo.getNow()==null&&areaCode!=null){
            String areaName1 = areaService.getAreaName(areaCode);
            fetchUtil.now(areaName1);
            fetchUtil.weatherHour(areaName1);
            fetchUtil.weatherDay(areaName1);
            if(weatherAreaMapper.selectByAreaName(areaName1)==null){
                WeatherArea weatherArea = new WeatherArea();
                weatherArea.setAreaName(areaName1);
                weatherAreaMapper.insertSelective(weatherArea);
            }
            TimeUnit.SECONDS.sleep(1);
            WeatherVo weatherVo2 = weatherHourService.getWeatherByCode(areaCode);
            result.setResult(weatherVo2);
            result.setSuccess(true);
        }
        return result;
    }

    @GetMapping("/getLocationWeather")
    @ApiOperation(value = "定位传参，获取当前地区天气状况")
    public Result<WeatherVo> getWeatherAreaLocation(String fullName) throws Exception {
        Result<WeatherVo> result = new Result<>();
        WeatherVo weatherVo = weatherHourService.getLocationWeather(fullName);
        if(weatherVo.getNow()!=null){
            result.setSuccessResult(weatherVo);
        }
        if(weatherVo.getNow()==null){
            String areaName1 = areaService.getAreaNameByFullName(fullName);
            fetchUtil.now(areaName1);
            fetchUtil.weatherHour(areaName1);
            fetchUtil.weatherDay(areaName1);
            if(weatherAreaMapper.selectByAreaName(areaName1)==null){
                WeatherArea weatherArea = new WeatherArea();
                weatherArea.setAreaName(areaName1);
                weatherAreaMapper.insertSelective(weatherArea);
            }
            TimeUnit.SECONDS.sleep(1);
            result.setSuccessResult(weatherHourService.getLocationWeather(fullName));
        }
        return result;
    }


    @PostMapping("/getAreaByName")
    @ApiOperation(value = "模糊搜索城市")
    public Result<List<Area>> getAreaByName(@RequestBody AreaNameVo areaNameVo){
        Result<List<Area>> result = new Result<>();
        result.setSuccessResult(areaService.getAreaByName(areaNameVo.getAreaName()));
        return result;
    }

}
