package com.nongxin.terminal.dao.nxboard;

import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.vo.nxboard.BaseVo;
import com.nongxin.terminal.vo.nxboard.LotVo;
import com.nongxin.terminal.vo.nxboard.WorkOrderVo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NxBoardMapper {

    //根据基地id获得基地农户
    List<User> getUserByBaseId(Integer baseId);

    List<String> getTechLead(Integer baseId);

    //根据基地id查询地块数量
    Integer getLotCount(Integer baseId);

    //根据基地id查询主要作物
    List<String> getCropByBaseId(Integer baseId);

    BaseVo getBaseInfo(Integer id);

    //根据基地id获取地块
    List<LotVo> getLotList(@Param("baseId")Integer baseId);

    List<String> getCropByLotId(Integer lotId);

    List<WorkOrderVo> getWorkOrderByBaseId(Integer baseId);
}
