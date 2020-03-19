package com.nongxin.terminal.controller.backstage.project;

import com.nongxin.terminal.entity.project.ProjectManage;
import com.nongxin.terminal.service.project.ProjectManageService;
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
@RequestMapping("/projectManage")
public class ProjectManageController {

    @Autowired
    private ProjectManageService projectManageService;

    @PostMapping("/add")
    @ApiOperation("添加项目管理")
    public Result add(@Validated @RequestBody ProjectManage projectManage){
        Result result = new Result();
        boolean isSuccess = projectManageService.add(projectManage);
        if (isSuccess){
            result.setMessage("添加成功");
        }else {
            result.setMessage("添加失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除项目管理")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = projectManageService.delete(id);
        if (isSuccess){
            result.setMessage("删除成功");
        }else {
            result.setMessage("删除失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改项目管理")
    public Result update(@RequestBody ProjectManage projectManage){
        Result result = new Result();
        boolean isSuccess = projectManageService.update(projectManage);
        if (isSuccess){
            result.setMessage("修改成功");
        }else {
            result.setMessage("修改失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation("查询项目管理")
    public Result list(){
        Result result = new Result();
        List<ProjectManage> projectManages = projectManageService.getProjectManage();
        List<MenuTreeNode> treeNodes = new ArrayList<>();
        for (ProjectManage projectManage: projectManages) {
            MenuTreeNode node = new MenuTreeNode();
            BeanUtils.copyProperties(projectManage,node);
            treeNodes.add(node);
        }
        List<MenuTreeNode> menuTreeNodes = TreeUtil.buildTreeBy2Loop(treeNodes,-1);
        result.setSuccessResult(menuTreeNodes);
        return result;
    }

    @GetMapping("/selectByParentId")
    @ApiOperation("根据父级查询")
    public Result selectByParentId(Integer parentId){
        Result result = new Result();
        result.setSuccessResult(projectManageService.selectByParentId(parentId));
        return result;
    }

}
