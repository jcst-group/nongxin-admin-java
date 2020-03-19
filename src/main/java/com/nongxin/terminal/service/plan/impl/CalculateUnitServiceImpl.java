package com.nongxin.terminal.service.plan.impl;

import com.nongxin.terminal.dao.plant.CalculateUnitMapper;
import com.nongxin.terminal.entity.plant.CalculateUnit;
import com.nongxin.terminal.service.plan.CalculateUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculateUnitServiceImpl implements CalculateUnitService {

    @Autowired(required = false)
    private CalculateUnitMapper calculateUnitMapper;

    @Override
    public boolean add(CalculateUnit calculateUnit) {
        return calculateUnitMapper.insertSelective(calculateUnit)==1;
    }

    @Override
    public boolean delete(Integer id) {
        return calculateUnitMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(CalculateUnit calculateUnit) {
        return calculateUnitMapper.updateByPrimaryKeySelective(calculateUnit)==1;
    }

    @Override
    public List<CalculateUnit> getCalculateUnit() {
        return calculateUnitMapper.getCalculateUnit();
    }

    @Override
    public List<CalculateUnit> getAllCalculateUnit() {
        return calculateUnitMapper.getAllCalculateUnit();
    }

    @Override
    public CalculateUnit selectByFarmingId(Integer farmingId) {
        return calculateUnitMapper.selectByFarmingId(farmingId);
    }

    @Override
    public CalculateUnit selectByTemporaryFarming(Integer farmingId) {
        return calculateUnitMapper.selectByTemporaryFarming(farmingId);
    }

    @Override
    public CalculateUnit selectByCropId(Integer cropId) {
        return calculateUnitMapper.selectByCropId(cropId);
    }
}
