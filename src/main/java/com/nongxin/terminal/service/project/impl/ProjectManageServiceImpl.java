package com.nongxin.terminal.service.project.impl;

import com.nongxin.terminal.dao.project.ProjectManageMapper;
import com.nongxin.terminal.entity.project.ProjectManage;
import com.nongxin.terminal.service.project.ProjectManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ProjectManageServiceImpl implements ProjectManageService {

    @Autowired(required = false)
    private ProjectManageMapper projectManageMapper;

    @Override
    public boolean add(ProjectManage projectManage) {
        if (projectManage.getParentId() == null){
            projectManage.setParentId(-1);
        }
        return projectManageMapper.insertSelective(projectManage)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        ProjectManage projectManage = projectManageMapper.selectByPrimaryKey(id);
        if (projectManage.getParentId() == -1){
            projectManageMapper.deleteByParentId(id);
        }
        return projectManageMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    public boolean update(ProjectManage projectManage) {
        return projectManageMapper.updateByPrimaryKeySelective(projectManage)==1;
    }

    @Override
    public List<ProjectManage> getProjectManage() {
        return projectManageMapper.getProjectManage();
    }

    @Override
    public List<ProjectManage> selectByParentId(Integer parentId) {
        if (parentId == null){
            parentId = -1;
        }
        return projectManageMapper.selectByParentId(parentId);
    }
}
