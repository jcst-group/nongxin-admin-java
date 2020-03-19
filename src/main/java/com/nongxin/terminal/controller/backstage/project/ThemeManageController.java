package com.nongxin.terminal.controller.backstage.project;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.project.ThemeManage;
import com.nongxin.terminal.service.project.ThemeManageService;
import com.nongxin.terminal.util.enumUtil.system.ThemeEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/themeManage")
public class ThemeManageController {

    @Autowired
    private ThemeManageService themeManageService;

    @PostMapping("/add")
    @ApiOperation("添加工作记录")
    public Result add(@Validated @RequestBody ThemeManage themeManage){
        Result result = new Result();
        boolean isSuccess = themeManageService.add(themeManage);
        if (isSuccess){
            result.setMessage("添加工作记录成功");
        }else {
            result.setMessage("添加工作记录失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除工作记录")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = themeManageService.delete(id);
        if (isSuccess){
            result.setMessage("删除工作记录成功");
        }else {
            result.setMessage("删除工作记录失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改工作记录")
    public Result update(@RequestBody ThemeManage themeManage){
        Result result = new Result();
        boolean isSuccess = themeManageService.update(themeManage);
        if (isSuccess){
            result.setMessage("修改工作记录成功");
        }else {
            result.setMessage("修改工作记录失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/updateStatus")
    @ApiOperation("修改工作记录状态")
    public Result updateStatus(ThemeManage themeManage){
        Result result = new Result();
        ThemeManage themeManage1 = themeManageService.selectById(themeManage.getId());
        if (themeManage1.getHandleEndTime() == null || themeManage1.getHandleStartTime() == null){
            result.error500("请先完善处理时间！！");
            return result;
        }
        themeManage.setStatus(ThemeEnum.COMPLETED);
        boolean isSuccess = themeManageService.update(themeManage);
        if (isSuccess){
            result.setMessage("修改工作记录状态成功");
        }else {
            result.setMessage("修改工作记录状态失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页带条件查询工作记录")
    public Result<PageInfo> getBaseList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                        @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                        String handlePerson,ThemeEnum status,Integer projectId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<ThemeManage> list = themeManageService.getThemeManage(handlePerson,status,projectId);
        PageInfo pageInfo = new PageInfo(list);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

}
