package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.dao.envmonitor.EnvMonitorScMapper;
import com.nongxin.terminal.entity.envmonitor.EnvMonitorSc;
import com.nongxin.terminal.service.envmonitor.EnvMonitorScService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EnvMonitorScServiceImpl implements EnvMonitorScService {

    @Autowired
    private EnvMonitorScMapper envMonitorScMapper;

    @Override
    public List<EnvMonitorSc> getEnvMonitorList(Integer equipmentId, Integer baseId, Date startTime, Date endTime) {
        return envMonitorScMapper.getEnvMonitorList(equipmentId,baseId,startTime,endTime);
    }
}
