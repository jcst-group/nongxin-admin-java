package com.nongxin.terminal.vo.workorder;

import com.nongxin.terminal.entity.system.User;

import java.math.BigDecimal;
import java.util.Date;

public class RealTimeOrder {

    private Integer id;

    private Date subTime;

    private String farmingName;

    private String orderContent;

    private User user;

    private BigDecimal longitude;

    private BigDecimal latitude;

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSubTime() {
        return subTime;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public String getFarmingName() {
        return farmingName;
    }

    public void setFarmingName(String farmingName) {
        this.farmingName = farmingName;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
