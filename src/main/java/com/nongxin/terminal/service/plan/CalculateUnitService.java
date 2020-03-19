package com.nongxin.terminal.service.plan;

import com.nongxin.terminal.entity.plant.CalculateUnit;

import java.util.List;

public interface CalculateUnitService {

   boolean add(CalculateUnit calculateUnit);

    boolean delete(Integer id);

    boolean update(CalculateUnit calculateUnit);

    List<CalculateUnit> getCalculateUnit();

    List<CalculateUnit> getAllCalculateUnit();

    //根据农事id查询计量单位
    CalculateUnit selectByFarmingId(Integer farmingId);

    //根据临时农事id查询计量单位
    CalculateUnit selectByTemporaryFarming(Integer farmingId);

    //根据作物id查询计量单位
    CalculateUnit selectByCropId(Integer cropId);

}
