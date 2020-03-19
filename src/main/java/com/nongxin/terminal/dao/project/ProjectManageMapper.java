package com.nongxin.terminal.dao.project;

import com.nongxin.terminal.entity.project.ProjectManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProjectManageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectManage record);

    int insertSelective(ProjectManage record);

    ProjectManage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectManage record);

    int updateByPrimaryKey(ProjectManage record);

    List<ProjectManage> getProjectManage();

    List<ProjectManage> selectByParentId(@Param("parentId") Integer parentId);

    int deleteByParentId(Integer parentId);

    Map<String,Object> getProjectManageAndParent(Integer id);

}