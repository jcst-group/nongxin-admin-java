package com.nongxin.terminal.service.envmonitor;

import com.nongxin.terminal.entity.envmonitor.EnvMonitorSc;

import java.util.Date;
import java.util.List;

public interface EnvMonitorScService {

    List<EnvMonitorSc> getEnvMonitorList(Integer equipmentId, Integer baseId, Date startTime, Date endTime);
}
