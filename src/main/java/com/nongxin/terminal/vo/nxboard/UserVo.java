package com.nongxin.terminal.vo.nxboard;

import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.util.enumUtil.system.UserSexEnum;
import com.nongxin.terminal.util.enumUtil.system.UserStatusEnum;

public class UserVo {

    private Integer uid;

    private String username;

    private String realName;

    private String phone;

    private UserSexEnum sex;

    private UserStatusEnum status;

    private PictureInfo headPic;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserSexEnum getSex() {
        return sex;
    }

    public void setSex(UserSexEnum sex) {
        this.sex = sex;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public void setStatus(UserStatusEnum status) {
        this.status = status;
    }

    public PictureInfo getHeadPic() {
        return headPic;
    }

    public void setHeadPic(PictureInfo headPic) {
        this.headPic = headPic;
    }
}
