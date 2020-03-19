package com.nongxin.terminal.service.base;

import com.nongxin.terminal.entity.base.Lot;
import com.nongxin.terminal.entity.plant.LotCalRel;
import com.nongxin.terminal.support.BaseException;
import com.nongxin.terminal.vo.base.LotCalVo;
import com.nongxin.terminal.vo.lookboard.LotTwoVo;

import java.util.List;
import java.util.Map;

public interface LotService {

    boolean add(Lot lot);

    boolean delete(Integer id);

    boolean update(Lot lot);

    List<Lot> getLotList(Integer baseId);

    List<Lot> getIdAndNameByBaseId(Integer baseId);

    Lot selectByPrimaryKey(Integer id);

    LotTwoVo getLotInBoard(Integer lotId);

    //查询地块规模
    List<LotCalVo> getLotScale(Integer[] lots, Integer cropId, Integer calId);

    //根据地块id查看地块规模
    List<Map<String,Object>> getLotScaleByLotId(Integer lotId);

    //修改地块对应作物规模
    boolean updateLotScale(List<LotCalRel> lotCalRelList);

    //添加地块对应作物规模
    boolean addLotScale(LotCalRel lotCalRel) throws BaseException;

    //删除地块对应作物规模
    boolean deleteLotScale(Integer lotId,Integer lotCalId) throws BaseException;

}
