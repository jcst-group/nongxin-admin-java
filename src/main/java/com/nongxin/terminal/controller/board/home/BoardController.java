package com.nongxin.terminal.controller.board.home;

import com.nongxin.terminal.dao.nxboard.NxBoardMapper;
import com.nongxin.terminal.entity.plant.WorkOrder;
import com.nongxin.terminal.service.base.BaseInfoService;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.nxboard.BaseVo;
import com.nongxin.terminal.vo.nxboard.LotVo;
import com.nongxin.terminal.vo.nxboard.WorkOrderVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/show/home")
public class BoardController {

    @Autowired
    private BaseInfoService baseInfoService;

    @Autowired
    private NxBoardMapper nxBoardMapper;

    @GetMapping("/getBaseByUid")
    @ApiOperation(value = "根据用户id查询对应基地")
    public Result<List<Map<String, Object>>> getBaseByUid(Integer uid){
        Result<List<Map<String, Object>>> result = new Result<>();
        result.setSuccessResult(baseInfoService.getBaseByUid(uid));
        return result;
    }

    @GetMapping("/getBaseByBaseId")
    @ApiOperation(value = "根据用户id查询对应基地")
    public Result<BaseVo> getBaseByBaseId(Integer id){
        Result<BaseVo> result = new Result<>();
        result.setSuccessResult(nxBoardMapper.getBaseInfo(id));
        return result;
    }

    @GetMapping("/getLotByBaseId")
    @ApiOperation(value = "根据基地id获取地块信息")
    public Result<List<LotVo>> getLotByBaseId(Integer id){
        Result<List<LotVo>> result = new Result<>();
        result.setSuccessResult(nxBoardMapper.getLotList(id));
        return result;
    }

    @GetMapping("/getWorkOrderByBaseId")
    @ApiOperation(value = "根据基地id获取地块信息")
    public Result<List<WorkOrderVo>> getWorkOrderByBaseId(Integer id){
        Result<List<WorkOrderVo>> result = new Result<>();
        result.setSuccessResult(nxBoardMapper.getWorkOrderByBaseId(id));
        return result;
    }
}
