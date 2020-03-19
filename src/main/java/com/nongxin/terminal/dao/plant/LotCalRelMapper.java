package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.LotCalRel;

public interface LotCalRelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LotCalRel record);

    int insertSelective(LotCalRel record);

    LotCalRel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LotCalRel record);

    int updateByPrimaryKey(LotCalRel record);

    LotCalRel getLotCal(LotCalRel lotCalRel);

    int getLotCalUseCount(Integer lotId,Integer lotCalId);
}