package com.nongxin.terminal.service.base.impl;

import com.nongxin.terminal.dao.base.LotMapper;
import com.nongxin.terminal.dao.plant.LotCalRelMapper;
import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.entity.plant.LotCalRel;
import com.nongxin.terminal.service.base.LotService;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.vo.base.LotCalVo;
import com.nongxin.terminal.vo.lookboard.LotTwoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

@Service
public class LotServiceImpl implements LotService {

    @Autowired(required = false)
    private LotMapper lotMapper;
    @Autowired(required = false)
    private LotCalRelMapper lotCalRelMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(Lot lot) {
        try {
            return lotMapper.insertSelective(lot)==1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return lotMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Lot lot) {
        try {
            lotMapper.updateByPrimaryKeySelective(lot);
            return lotMapper.updateByPrimaryKeySelective(lot)==1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<Lot> getLotList(Integer baseId) {
        return lotMapper.getLotList(baseId);
    }

    @Override
    public List<Lot> getIdAndNameByBaseId(Integer baseId) {
        return lotMapper.getIdAndNameByBaseId(baseId);
    }

    @Override
    public Lot selectByPrimaryKey(Integer id) {
        return lotMapper.selectByPrimaryKey(id);
    }

    @Override
    public LotTwoVo getLotInBoard(Integer lotId) {
        return lotMapper.getLotInBoard(lotId);
    }

    @Override
    public List<LotCalVo> getLotScale(Integer[] lots, Integer cropId, Integer calId) {
        return lotMapper.getLotScale(lots,cropId,calId);
    }

    @Override
    public List<Map<String, Object>> getLotScaleByLotId(Integer lotId) {
        return lotMapper.getLotScaleByLotId(lotId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateLotScale(List<LotCalRel> lotCalRelList) {
        for (LotCalRel lotCalRel : lotCalRelList) {
            lotCalRelMapper.updateByPrimaryKeySelective(lotCalRel);
        }
        return true;
    }

    @Override
    public boolean addLotScale(LotCalRel lotCalRel) throws BaseException {
        if (lotCalRelMapper.getLotCal(lotCalRel) != null){
            throw new BaseException(500,"该地块已存在对应作物规模，无法重复添加！！");
        }
        return lotCalRelMapper.insertSelective(lotCalRel)==1;
    }

    @Override
    public boolean deleteLotScale(Integer lotId, Integer lotCalId) throws BaseException {
        Integer count = lotCalRelMapper.getLotCalUseCount(lotId,lotCalId);
        if (count>0){
            throw new BaseException(500,"改地块规模已被使用，无法删除！！");
        }
        return lotCalRelMapper.deleteByPrimaryKey(lotCalId)==1;
    }

}
