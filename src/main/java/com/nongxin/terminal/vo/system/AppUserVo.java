package com.nongxin.terminal.vo.system;

import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.util.enumUtil.system.UserSexEnum;
import lombok.Data;

import java.util.List;

@Data
public class AppUserVo {

    private Integer uid;

    private String username;

    private String realName;

    private String phone;

    private UserSexEnum sex;

    private PictureInfo headPic;

    private List<Role> roleList;

    private Integer baseCount;

    private Integer lotCount;

}
