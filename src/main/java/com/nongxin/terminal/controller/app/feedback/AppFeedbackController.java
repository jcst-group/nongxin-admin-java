package com.nongxin.terminal.controller.app.feedback;

import com.nongxin.terminal.entity.feedback.Feedback;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.feedback.FeedbackService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.constant.DefContants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/app/feedBack")
public class AppFeedbackController {

    @Autowired
    private FeedbackService feedbackService;
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation("添加巡视记录")
    public Result addFeedBack(@Validated @RequestBody Feedback feedback, HttpServletRequest request){
        Result result = new Result();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        User user = userService.getUserByUserName(JwtUtil.getUsername(token),null);
        feedback.setUserId(user.getUid());
        boolean isSuccess = feedbackService.add(feedback);
        if (isSuccess){
            result.setMessage("添加巡视记录成功");
        }else{
            result.setMessage("添加巡视记录失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

}
