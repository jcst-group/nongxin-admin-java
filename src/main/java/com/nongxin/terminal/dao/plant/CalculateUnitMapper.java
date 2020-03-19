package com.nongxin.terminal.dao.plant;

import com.nongxin.terminal.entity.plant.CalculateUnit;

import java.util.List;

public interface CalculateUnitMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CalculateUnit record);

    int insertSelective(CalculateUnit record);

    CalculateUnit selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CalculateUnit record);

    int updateByPrimaryKey(CalculateUnit record);

    List<CalculateUnit> getCalculateUnit();

    List<CalculateUnit> getAllCalculateUnit();

    CalculateUnit selectByFarmingId(Integer farmingId);

    CalculateUnit selectByTemporaryFarming(Integer farmingId);

    CalculateUnit selectByCropId(Integer cropId);
}