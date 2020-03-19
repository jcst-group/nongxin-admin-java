package com.nongxin.terminal.dao.system;

import com.nongxin.terminal.entity.system.ShowResourceRel;

import java.util.List;

public interface ShowResourceRelMapper {
    int insert(ShowResourceRel record);

    int insertSelective(ShowResourceRel record);

    List<ShowResourceRel> selectByResourceId(Integer resourceId);
}