package com.nongxin.terminal.controller.board.system;

import com.alibaba.fastjson.JSONObject;
import com.nongxin.terminal.entity.system.AppResource;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.entity.system.ShowResource;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.service.system.RoleService;
import com.nongxin.terminal.service.system.ShowResourceService;
import com.nongxin.terminal.service.system.UserService;
import com.nongxin.terminal.util.JwtUtil;
import com.nongxin.terminal.util.Md5Util;
import com.nongxin.terminal.util.RedisUtil;
import com.nongxin.terminal.util.enumUtil.system.ResourceTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.RoleTypeEnum;
import com.nongxin.terminal.util.enumUtil.system.UserStatusEnum;
import com.nongxin.terminal.vo.Result;
import com.nongxin.terminal.vo.SysLoginModel;
import com.nongxin.terminal.vo.constant.CommonConstant;
import com.nongxin.terminal.vo.constant.DefContants;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/show/user")
public class BoardUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ShowResourceService showResourceService;

    @PostMapping("/login")
    @ApiOperation("登录接口")
    public Result<JSONObject> login(@RequestBody SysLoginModel sysLoginModel, HttpServletRequest request){
        Result<JSONObject> result = new Result<>();
        //LOGGER.info("login :"+sysLoginModel.toString());
        String username = sysLoginModel.getUsername();
        String password = sysLoginModel.getPassword();
        User user = userService.getUserByUserName(username,null);
        if(user==null) {
            result.error500("用户名或密码错误");
        }else if (user.getStatus()== UserStatusEnum.PROHIBIT){
            result.error500("该账号已被禁用！！");
            return result;
        }else{
            //加密密码时的办法
            String checkStr = password+user.getSalt();
            String inputPassword = Md5Util.md5(checkStr);
            String userPassword = user.getPassword();
            if(!userPassword.equals(inputPassword)) {
                result.error500("用户名或密码错误");
                return result;
            }
            List<Role> roleList = roleService.getRoleByUid(user.getUid());
            if (roleList==null || roleList.isEmpty()){
                result.error500("该用户暂未分配角色，无法登录");
                return result;
            }
            /*List<ShowResource> showResourceList = showResourceService.getShowResourceByUid(user.getUid(), ResourceTypeEnum.BACK_RECOURCE);
            if (showResourceList == null || showResourceList.isEmpty()){
                result.error500("该用户暂无权限，无法登录");
                return result;
            }*/
            //生成token
            String token = JwtUtil.sign(user.getUsername(), password);
            redisUtil.set(CommonConstant.PREFIX_SHOW_TOKEN + token, token);
            //设置超时时间
            redisUtil.expire(CommonConstant.PREFIX_SHOW_TOKEN + token, JwtUtil.EXPIRE_TIME/1000);
            JSONObject obj = new JSONObject();
            obj.put("token", token);
            obj.put("userInfo", user);
            result.setResult(obj);
            result.success("登录成功");
        }
        return result;
    }

    @GetMapping("/logout")
    @ApiOperation("退出登录")
    public Result<String> LogOut(HttpServletRequest request){
        Result<String> result = new Result<>();
        String token = request.getHeader(DefContants.X_ACCESS_TOKEN);
        redisUtil.del(CommonConstant.PREFIX_APP_TOKEN+token);
        result.setSuccess(true);
        result.setMessage("已退出");
        return result;
    }

}
