package com.nongxin.terminal.controller.board.mzboard;

import com.nongxin.terminal.dao.envmonitor.EnvMonitorScMapper;
import com.nongxin.terminal.dao.envmonitor.EquipmentMapper;
import com.nongxin.terminal.entity.envmonitor.EnvMonitorSc;
import com.nongxin.terminal.entity.envmonitor.Equipment;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mZBoard")
public class MzBoardController {

    @Autowired
    private EnvMonitorScMapper envMonitorScMapper;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @GetMapping("/getLastMonitor")
    @ApiOperation(value = "获取最新的采集数据")
    public Result<List<EnvMonitorSc>> getListLastMonitor(){
        Result<List<EnvMonitorSc>> result = new Result();
        List<EnvMonitorSc> envMonitorList = envMonitorScMapper.getLastMonitor();
        result.setResult(envMonitorList);
        result.setSuccess(true);
        return result;
    }

    @GetMapping("/getEquipmentByBaseId")
    public Result<List<Equipment>> getEquipment(Integer baseId){
        Result<List<Equipment>> result = new Result<>();
        List<Equipment> list = equipmentMapper.getEquipmentByBaseId(baseId);
        if(list!=null){
            result.setResult(list);
            result.setSuccess(true);
        }else {
            result.setSuccess(false);
        }
        return result;
    }
}
