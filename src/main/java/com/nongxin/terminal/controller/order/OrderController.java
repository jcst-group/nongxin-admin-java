package com.nongxin.terminal.controller.order;

import com.nongxin.terminal.entity.order.OrderInfo;
import com.nongxin.terminal.service.order.OrderInfoService;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoService;

    @PostMapping("/add")
    @ApiOperation(value = "新增订单")
    public Result<OrderInfo> insertEquipment(@Validated @RequestBody OrderInfo orderInfo) {
        Result<OrderInfo> result = new Result<>();
        boolean isInsertSuccess = orderInfoService.insert(orderInfo);
        if (isInsertSuccess == true) {
            result.setMessage("新增成功");
        } else {
            result.setMessage("新增失败");
        }
        result.setSuccess(isInsertSuccess);
        return result;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查看所有订单")
    public Result<List<OrderInfo>> getAllList(){
        Result<List<OrderInfo>> result = new Result<>();
        List<OrderInfo> list = orderInfoService.getAllList();
        if(list!=null){
            result.setResult(list);
            result.setSuccess(true);
            result.setCode(200);
            result.setMessage("获取成功");
        }else{
            result.setCode(404);
            result.setSuccess(false);
            result.setMessage("获取失败");
        }
        return result;
    }
}
