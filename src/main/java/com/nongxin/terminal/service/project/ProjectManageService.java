package com.nongxin.terminal.service.project;

import com.nongxin.terminal.entity.project.ProjectManage;

import java.util.List;

public interface ProjectManageService {

    boolean add(ProjectManage projectManage);

    boolean delete(Integer id);

    boolean update(ProjectManage projectManage);

    List<ProjectManage> getProjectManage();

    List<ProjectManage> selectByParentId(Integer parentId);

}
