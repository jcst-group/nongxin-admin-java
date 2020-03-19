package com.nongxin.terminal.vo.nxboard;

import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.system.User;

import java.math.BigDecimal;
import java.util.List;

public class BaseVo {

    private Integer id;

    private List<User> userList;

    private String baseName;

    private List<String> techLead;

    private BigDecimal baseAcreage;

    private Integer lotCount;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private List<String> crop;

    private Address address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public List<String> getTechLead() {
        return techLead;
    }

    public void setTechLead(List<String> techLead) {
        this.techLead = techLead;
    }

    public BigDecimal getBaseAcreage() {
        return baseAcreage;
    }

    public void setBaseAcreage(BigDecimal baseAcreage) {
        this.baseAcreage = baseAcreage;
    }

    public Integer getLotCount() {
        return lotCount;
    }

    public void setLotCount(Integer lotCount) {
        this.lotCount = lotCount;
    }

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

    public List<String> getCrop() {
        return crop;
    }

    public void setCrop(List<String> crop) {
        this.crop = crop;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
