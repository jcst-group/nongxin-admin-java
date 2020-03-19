package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.EnvMonitor;
import com.nongxin.terminal.entity.envmonitor.EnvMonitorSc;

import java.util.Date;
import java.util.List;

public interface EnvMonitorScMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EnvMonitorSc record);

    int insertSelective(EnvMonitor record);

    EnvMonitorSc selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EnvMonitorSc record);

    int updateByPrimaryKey(EnvMonitorSc record);

    List<EnvMonitorSc> selectByEquipIdAndMeasureTime(EnvMonitorSc record);

    List<EnvMonitorSc> getLastMonitor();

    List<EnvMonitorSc> getEnvMonitorList(Integer equipmentId, Integer baseId, Date startTime, Date endTime);
}