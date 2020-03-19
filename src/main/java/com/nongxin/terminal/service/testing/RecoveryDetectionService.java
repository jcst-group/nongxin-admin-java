package com.nongxin.terminal.service.testing;

import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.testing.RecoveryDetection;
import com.nongxin.terminal.entity.testing.SeedDetection;

import java.util.Date;
import java.util.List;

public interface RecoveryDetectionService {

    boolean add(RecoveryDetection recoveryDetection);

    boolean delete(Integer id);

    boolean update(RecoveryDetection recoveryDetection);

    List<RecoveryDetection> getRecoveryDetection(Integer planId,Date startTime, Date endTime);

    //根据追溯码查询采收检测图片
    PictureInfo getPicByRetroCode(String retroCode);

    //根据批次id查询采收检测图片
    PictureInfo getPicByBatchId(Integer batchId);

}
