package com.nongxin.terminal.service.project;

import com.nongxin.terminal.entity.project.ThemeManage;
import com.nongxin.terminal.util.enumUtil.system.ThemeEnum;

import java.util.List;

public interface ThemeManageService {

    boolean add(ThemeManage themeManage);

    boolean delete(Integer id);

    boolean update(ThemeManage themeManage);

    List<ThemeManage> getThemeManage(String handlePerson,ThemeEnum status,Integer projectId);

    ThemeManage selectById(Integer id);

}
