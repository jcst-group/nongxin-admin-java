package com.nongxin.terminal.service.cms.impl;

import com.nongxin.terminal.entity.cms.Category;
import com.nongxin.terminal.dao.cms.CategoryMapper;
import com.nongxin.terminal.service.cms.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
