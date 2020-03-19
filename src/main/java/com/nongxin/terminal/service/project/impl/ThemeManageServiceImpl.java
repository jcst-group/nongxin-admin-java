package com.nongxin.terminal.service.project.impl;

import com.nongxin.terminal.dao.file.FileInfoMapper;
import com.nongxin.terminal.dao.project.ThemeManageMapper;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.project.ThemeManage;
import com.nongxin.terminal.service.project.ThemeManageService;
import com.nongxin.terminal.util.FileUpload;
import com.nongxin.terminal.util.enumUtil.system.ThemeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Service
public class ThemeManageServiceImpl implements ThemeManageService {

    @Autowired(required = false)
    private ThemeManageMapper themeManageMapper;
    @Autowired(required = false)
    private FileInfoMapper fileInfoMapper;
    @Autowired
    private FileUpload fileUpload;


    @Override
    public boolean add(ThemeManage themeManage) {
        if (themeManage.getParentId() == null){
            themeManage.setParentId(-1);
        }
        themeManage.setStatus(ThemeEnum.INCOMPLETE);
        return themeManageMapper.insertSelective(themeManage)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<FileInfo> fileInfos = fileInfoMapper.getTaskFile(id);
        if (fileInfos != null && !fileInfos.isEmpty()){
            for (FileInfo fileInfo : fileInfos) {
                File file = new File(fileUpload.getPath(fileInfo.getFileUrl()));
                file.delete();
                fileInfoMapper.deleteByPrimaryKey(id);
            }
        }
        return themeManageMapper.deleteById(id)>0;
    }

    @Override
    public boolean update(ThemeManage themeManage) {
        return themeManageMapper.updateByPrimaryKeySelective(themeManage)==1;
    }

    @Override
    public List<ThemeManage> getThemeManage(String handlePerson, ThemeEnum status,Integer projectId) {
        return themeManageMapper.getThemeManage(handlePerson,status,projectId);
    }

    @Override
    public ThemeManage selectById(Integer id) {
        return themeManageMapper.selectByPrimaryKey(id);
    }
}
