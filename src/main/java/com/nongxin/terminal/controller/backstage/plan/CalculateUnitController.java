package com.nongxin.terminal.controller.backstage.plan;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.plant.CalculateUnit;
import com.nongxin.terminal.service.plan.CalculateUnitService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calculateUnit")
public class CalculateUnitController {

    @Autowired
    private CalculateUnitService calculateUnitService;

    @PostMapping("/add")
    @ApiOperation("添加计量单位")
    public Result addFarmingItem(@Validated @RequestBody CalculateUnit calculateUnit){
        Result result = new Result();
        boolean isSuccess = calculateUnitService.add(calculateUnit);
        if (isSuccess){
            result.setMessage("添加计量单位成功");
        }else {
            result.setMessage("添加计量单位失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除农事项目")
    public Result deleteFarmingItem(Integer id){
        Result result = new Result();
        boolean isSuccess = calculateUnitService.delete(id);
        if (isSuccess){
            result.setMessage("删除农事项目成功");
        }else {
            result.setMessage("删除农事项目失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改计量单位")
    public Result updateFarmingItem(@RequestBody CalculateUnit calculateUnit){
        Result result = new Result();
        boolean isSuccess = calculateUnitService.update(calculateUnit);
        if (isSuccess){
            result.setMessage("修改计量单位成功");
        }else {
            result.setMessage("修改计量单位失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "分页查询计量单位")
    public Result<PageInfo> getFarmingItemList(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                               @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize){
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        List<CalculateUnit> calculateUnitList = calculateUnitService.getCalculateUnit();
        PageInfo pageInfo = new PageInfo(calculateUnitList);
        result.setSuccessResult(pageInfo);
        return result;
    }

    @GetMapping("/all")
    @ApiOperation("查询所有计量单位，用于下拉列表选择")
    public Result updateFarmingItem(){
        Result result = new Result();
        result.setSuccessResult(calculateUnitService.getAllCalculateUnit());
        return result;
    }

    @GetMapping("/selectByFarmingId")
    @ApiOperation("根据农事id查询单位")
    public Result selectByFarmingId(Integer farmingId){
        Result result = new Result();
        result.setSuccessResult(calculateUnitService.selectByFarmingId(farmingId));
        return result;
    }

    @GetMapping("/selectByTemporaryFarming")
    @ApiOperation("根据临时农事id查询单位")
    public Result selectByTemporaryFarming(Integer farmingId){
        Result result = new Result();
        result.setSuccessResult(calculateUnitService.selectByTemporaryFarming(farmingId));
        return result;
    }

    @GetMapping("/selectByCropId")
    @ApiOperation("根据作物id查询单位")
    public Result selectByCropId(Integer cropId){
        Result result = new Result();
        result.setSuccessResult(calculateUnitService.selectByCropId(cropId));
        return result;
    }

}
