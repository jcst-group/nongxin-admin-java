package com.nongxin.terminal.entity.plant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.file.FileInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.entity.system.Role;
import com.nongxin.terminal.entity.system.User;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderTypeEnum;
import com.nongxin.terminal.util.enumUtil.solar.SolarTermsEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class WorkOrder {
    private Integer id;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date executionTime;

    private SolarTermsEnum solarTerm;

    private Integer cropBatchId;

    private Integer farmingItemId;

    private Integer userId;

    private WorkOrderStatusEnum status;

    private WorkOrderTypeEnum type;

    private List<Role> roleList;

    private List<PictureInfo> pictureInfoList;

    private List<DeviceAct> deviceActList;

    private List<MaterialAct> materialActList;

    private List<PersonnelAct> personnelActList;

    private CropBatch cropBatch;

    private User user;

    private FarmingItem farmingItem;

    private FileInfo fileInfo;

    private String remark;

    private Integer farmingId;

    private OrderContent orderContent;

    //提交时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date subTime;

    //审核时间
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date examineTime;

    public Date getSubTime() {
        return subTime;
    }

    public void setSubTime(Date subTime) {
        this.subTime = subTime;
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public OrderContent getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(OrderContent orderContent) {
        this.orderContent = orderContent;
    }

    public Integer getFarmingId() {
        return farmingId;
    }

    public void setFarmingId(Integer farmingId) {
        this.farmingId = farmingId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    public FarmingItem getFarmingItem() {
        return farmingItem;
    }

    public void setFarmingItem(FarmingItem farmingItem) {
        this.farmingItem = farmingItem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CropBatch getCropBatch() {
        return cropBatch;
    }

    public void setCropBatch(CropBatch cropBatch) {
        this.cropBatch = cropBatch;
    }

    public List<DeviceAct> getDeviceActList() {
        return deviceActList;
    }

    public void setDeviceActList(List<DeviceAct> deviceActList) {
        this.deviceActList = deviceActList;
    }

    public List<MaterialAct> getMaterialActList() {
        return materialActList;
    }

    public void setMaterialActList(List<MaterialAct> materialActList) {
        this.materialActList = materialActList;
    }

    public List<PersonnelAct> getPersonnelActList() {
        return personnelActList;
    }

    public void setPersonnelActList(List<PersonnelAct> personnelActList) {
        this.personnelActList = personnelActList;
    }

    public List<PictureInfo> getPictureInfoList() {
        return pictureInfoList;
    }

    public void setPictureInfoList(List<PictureInfo> pictureInfoList) {
        this.pictureInfoList = pictureInfoList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public SolarTermsEnum getSolarTerm() {
        return solarTerm;
    }

    public void setSolarTerm(SolarTermsEnum solarTerm) {
        this.solarTerm = solarTerm;
    }

    public Integer getCropBatchId() {
        return cropBatchId;
    }

    public void setCropBatchId(Integer cropBatchId) {
        this.cropBatchId = cropBatchId;
    }

    public Integer getFarmingItemId() {
        return farmingItemId;
    }

    public void setFarmingItemId(Integer farmingItemId) {
        this.farmingItemId = farmingItemId;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public WorkOrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(WorkOrderStatusEnum status) {
        this.status = status;
    }

    public WorkOrderTypeEnum getType() {
        return type;
    }

    public void setType(WorkOrderTypeEnum type) {
        this.type = type;
    }
}