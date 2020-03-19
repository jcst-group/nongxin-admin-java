package com.nongxin.terminal.dao.project;

import com.nongxin.terminal.entity.project.ThemeManage;
import com.nongxin.terminal.util.enumUtil.system.ThemeEnum;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ThemeManageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ThemeManage record);

    int insertSelective(ThemeManage record);

    ThemeManage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ThemeManage record);

    int updateByPrimaryKey(ThemeManage record);

    List<ThemeManage> getThemeManage(@Param("handlePerson") String handlePerson, @Param("status") ThemeEnum status,@Param("projectId")Integer projectId);

    int deleteById(Integer id);

    List<ThemeManage> selectByParentId(Integer parentId);

}