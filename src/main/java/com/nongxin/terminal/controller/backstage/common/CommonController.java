package com.nongxin.terminal.controller.backstage.common;

import com.nongxin.terminal.service.system.ConstantStorageService;
import com.nongxin.terminal.util.YsClient;
import com.nongxin.terminal.util.enumUtil.system.ConstantTypeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class CommonController {

    @Autowired
    private YsClient ysClient;
    @Autowired
    private ConstantStorageService constantStorageService;

    @GetMapping("/getYsToken")
    public Result getYsToken(){
        Result result = new Result();
        result.setSuccessResult(ysClient.HttpClientPost());
        return result;
    }

    @GetMapping("/getTraceabilityUrl")
    @ApiOperation("获取溯源地址")
    public Result getTraceabilityUrl(){
        Result result = new Result();
        result.setSuccessResult(constantStorageService.selectByType(ConstantTypeEnum.TRACEABILITY));
        return result;
    }

}
