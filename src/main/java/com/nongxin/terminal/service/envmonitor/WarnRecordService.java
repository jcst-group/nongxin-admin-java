package com.nongxin.terminal.service.envmonitor;


import com.nongxin.terminal.entity.envmonitor.WarnRecord;
import com.nongxin.terminal.vo.app.AppEnvRecordVo;

import java.util.Date;
import java.util.List;

public interface WarnRecordService {

    boolean insertSelective(WarnRecord record);

    List<WarnRecord> getWarnRecordByTime(Integer typeId,String[] baseid);

    List<AppEnvRecordVo> getRecordByTime(Date time);

    List<WarnRecord> getRecordList(Integer equipmentId, Integer baseId, Date startTime, Date endTime);
}
