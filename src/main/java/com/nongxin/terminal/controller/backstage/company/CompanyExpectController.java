package com.nongxin.terminal.controller.backstage.company;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.company.CompanyExpect;
import com.nongxin.terminal.entity.company.CompanyInfo;
import com.nongxin.terminal.service.company.CompanyExpectService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nongxin
 * @since 2019-10-29
 */
@RestController
@RequestMapping("/companyExpect")
public class CompanyExpectController {

    @Autowired
    private CompanyExpectService companyExpectService;

    @PostMapping("/add")
    @ApiOperation("添加预期愿景")
    public Result add(@Validated @RequestBody CompanyExpect companyExpect){
        Result result = new Result();
        System.out.println(companyExpect.toString());
        boolean isSuccess = companyExpectService.add(companyExpect);
        if (isSuccess){
            result.setMessage("添加预期愿景成功");
        }else {
            result.setMessage("添加预期愿景失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除预期愿景")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = companyExpectService.delete(id);
        if (isSuccess){
            result.setMessage("删除预期愿景成功");
        }else {
            result.setMessage("删除预期愿景失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改预期愿景")
    public Result update(@RequestBody CompanyExpect companyExpect){
        Result result = new Result();
        boolean isSuccess = companyExpectService.update(companyExpect);
        if (isSuccess){
            result.setMessage("修改预期愿景成功");
        }else {
            result.setMessage("修改预期愿景失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询预期愿景")
    public Result<PageInfo> getCompanyExpectList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                           @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                                                 Integer companyId){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<CompanyExpect> companyExpectList = companyExpectService.getCompanyExpect(companyId);
        PageInfo pageInfo = new PageInfo(companyExpectList);
        result.setResult(pageInfo);
        result.setSuccess(true);
        return result;
    }

}
