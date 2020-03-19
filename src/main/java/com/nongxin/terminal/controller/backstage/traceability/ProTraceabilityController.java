package com.nongxin.terminal.controller.backstage.traceability;

import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.traceability.ProTraceability;
import com.nongxin.terminal.service.base.BaseInfoService;
import com.nongxin.terminal.service.base.impl.BaseInfoServiceImpl;
import com.nongxin.terminal.service.plan.MaterialInfoService;
import com.nongxin.terminal.service.testing.RecoveryDetectionService;
import com.nongxin.terminal.service.traceability.ProTraceabilityService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/proTraceability")
public class ProTraceabilityController {

    @Autowired
    private ProTraceabilityService proTraceabilityService;
    @Autowired
    private BaseInfoServiceImpl baseInfoService;
    @Autowired
    private MaterialInfoService materialInfoService;
    @Autowired
    private RecoveryDetectionService recoveryDetectionService;

    @GetMapping("/getProTraceability")
    @ApiOperation("获取溯源产品信息")
    public Result getProTraceability(@RequestParam(required = true)Integer batchId){
        Result result = new Result();
        result.setSuccessResult(proTraceabilityService.selectByBatchId(batchId));
        return result;
    }

    @PostMapping("/add")
    @ApiOperation("添加/修改溯源产品信息")
    public Result add(@RequestBody ProTraceability proTraceability){
        Result result = new Result();
        boolean isSuccess = proTraceabilityService.add(proTraceability);
        if (isSuccess){
            result.setMessage("操作成功");
        }else {
            result.setMessage("操作失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/getBatchAndBase")
    @ApiOperation("获取溯源相关批次信息")
    public Result<Map<String,Object>> getBatchAndBase(@RequestParam(required = true) Integer batchId){
        Result<Map<String,Object>> result = new Result<>();
        result.setSuccessResult(proTraceabilityService.getBatchAndBase(batchId));
        return result;
    }

    @GetMapping("/getBaseById")
    @ApiOperation("获取基地信息")
    public Result<BaseInfo> getBaseById(Integer baseId){
        Result<BaseInfo> result = new Result<>();
        result.setSuccessResult(baseInfoService.getBaseById(baseId));
        return result;
    }

    @GetMapping("/getTraceabilityPic")
    @ApiOperation("获取溯源相关检测图片")
    public Result getTraceabilityPic(@RequestParam(required = true) Integer batchId){
        Result result = new Result();
        result.setSuccessResult(proTraceabilityService.getDetectionPicByBatchId(batchId));
        return result;
    }

    @GetMapping("/getMaterialPic")
    @ApiOperation("获取物料检测图片")
    public Result getMaterialPic(@RequestParam(required = true) Integer batchId){
        Result result = new Result();
        result.setSuccessResult(materialInfoService.getMaterialPicByBatchId(batchId));
        return result;
    }

    @GetMapping("/getBaseDetectionPic")
    @ApiOperation("获取基地检测图片")
    public Result getBaseDetectionPic(@RequestParam(required = true) Integer batchId){
        Result result = new Result();
        result.setSuccessResult(baseInfoService.getBaseDetectionPic(null,batchId));
        return result;
    }

    @GetMapping("/getPicByBatchId")
    @ApiOperation("获取采收检测图片")
    public Result getPicByBatchId(@RequestParam(required = true) Integer batchId){
        Result result = new Result();
        result.setSuccessResult(recoveryDetectionService.getPicByBatchId(batchId));
        return result;
    }

}
