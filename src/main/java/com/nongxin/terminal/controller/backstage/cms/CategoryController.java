package com.nongxin.terminal.controller.backstage.cms;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nongxin.terminal.entity.cms.Category;
import com.nongxin.terminal.entity.project.ProjectManage;
import com.nongxin.terminal.service.cms.CategoryService;
import com.nongxin.terminal.util.TreeUtil;
import com.nongxin.terminal.vo.MenuTreeNode;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    @ApiOperation("添加类别")
    public Result add(@Validated @RequestBody Category category){
        Result result = new Result();
        category.setStatus(1);
        boolean isSuccess = categoryService.save(category);
        if (isSuccess){
            result.setMessage("添加类别成功");
        }else{
            result.setMessage("添加类别失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除类别")
    public Result delete(Integer id){
        Result result = new Result();
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id).or().eq("parent_id",id);
        boolean isSuccess = categoryService.remove(queryWrapper);
        if (isSuccess){
            result.setMessage("删除类别成功");
        }else{
            result.setMessage("删除类别失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改类别")
    public Result update(@RequestBody Category category){
        Result result = new Result();
        boolean isSuccess = categoryService.updateById(category);
        if (isSuccess){
            result.setMessage("修改类别成功");
        }else{
            result.setMessage("修改类别失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation("查询所有类别")
    public Result list(){
        Result result = new Result();
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status",1);
        List<Category> categoryList = categoryService.list(queryWrapper);
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        for (Category category: categoryList) {
            MenuTreeNode node = new MenuTreeNode();
            node.setName(category.getCategory());
            BeanUtils.copyProperties(category,node);
            treeNodes.add(node);
        }
        List<MenuTreeNode> menuTreeNodes = TreeUtil.buildTreeBy2Loop(treeNodes,-1);
        result.setSuccessResult(menuTreeNodes);
        return result;
    }

}
