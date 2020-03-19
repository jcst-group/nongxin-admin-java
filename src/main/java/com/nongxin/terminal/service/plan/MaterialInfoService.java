package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.plant.Farming;
import com.nongxin.terminal.entity.plant.MaterialInfo;

import java.util.List;

public interface MaterialInfoService {

    boolean add(MaterialInfo materialInfo);

    boolean delete(Integer id);

    boolean update(MaterialInfo materialInfo);

    List<MaterialInfo> selectByFarmingId(Integer farmingId);

    //根据批次id查询农资品检测报告
    List<PictureInfo> getMaterialPicByBatchId(Integer batchId);

    //根据追溯码查询农资品检测报告
    List<PictureInfo> getMaterialPicByRetroCode(String retroCode);

}
