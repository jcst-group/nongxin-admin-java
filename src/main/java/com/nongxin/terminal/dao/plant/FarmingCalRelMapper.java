package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.FarmingCalRel;

public interface FarmingCalRelMapper {
    int insert(FarmingCalRel record);

    int insertSelective(FarmingCalRel record);

    int deleteByFarmingId(Integer farmingId);
}