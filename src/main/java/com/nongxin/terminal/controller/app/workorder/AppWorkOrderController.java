package com.nongxin.terminal.controller.app.workorder;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nongxin.terminal.entity.plant.WorkOrder;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.plan.WorkOrderService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.constant.DefContants;
import com.nongxin.terminal.vo.workorder.AppOrderVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/app/workOrder")
public class AppWorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;
    @Autowired
    private UserService userService;

    @GetMapping("/getUserOrder")
    @ApiOperation("获取用户工单")
    public Result<PageInfo> getUserOrder(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                 @RequestParam(name = "pageSize" ,defaultValue = "5") Integer pageSize,
                                                HttpServletRequest request,WorkOrderStatusEnum status,Integer batchId){
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        User user = userService.getUserByUserName(JwtUtil.getUsername(token),null);
        Result<PageInfo> result = new Result<>();
        PageHelper.startPage(pageNo,pageSize);
        PageInfo pageInfo = new PageInfo(workOrderService.getAppOrderVo(user.getUid(),status,batchId));
        result.setSuccessResult(pageInfo);
        return result;
    }

    /*@GetMapping("/getUserOrder")
    @ApiOperation("获取用户工单")
    public Result getUserOrder(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                         @RequestParam(name = "pageSize" ,defaultValue = "5") Integer pageSize,
                                         HttpServletRequest request,WorkOrderStatusEnum status,Integer batchId){
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        User user = userService.getUserByUserName(JwtUtil.getUsername(token),null);
        Result result = new Result<>();
        result.setSuccessResult(workOrderService.getAppOrderVo(user.getUid(),status,batchId));
        return result;
    }*/

    @PostMapping("/executingOrder")
    @ApiOperation("执行工单")
    public Result executingOrder(@RequestBody WorkOrder workOrder,HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        User user = userService.getUserByUserName(JwtUtil.getUsername(token),null);
        workOrder.setUserId(user.getUid());
        workOrder.setSubTime(new Date());
        boolean isSuccess = workOrderService.executingOrder(workOrder);
        if (isSuccess){
            result.setMessage("执行工单成功");
        }else{
            result.setMessage("执行工单失败");
        }
        result.setSuccess(isSuccess);
        return  result;
    }

    @GetMapping("/getOrderCosts")
    @ApiOperation("获取工单费用")
    public Result<AppOrderVo> getOrderCosts(Integer id){
        Result<AppOrderVo> result = new Result<>();
        result.setSuccessResult(workOrderService.getOrderCosts(id));
        return result;
    }

    @GetMapping("/selectById")
    @ApiOperation("获取工单费用")
    public Result<WorkOrder> selectById(Integer id){
        Result<WorkOrder> result = new Result<>();
        result.setSuccessResult(workOrderService.selectByPrimaryKey(id));
        return result;
    }

    @GetMapping("/getOrderIsLocal")
    @ApiOperation("获取工单是否需要定位")
    public Result getOrderIsLocal(Integer orderId){
        Result result = new Result<>();
        result.setSuccessResult(workOrderService.getOrderIsLocal(orderId));
        return result;
    }

}
