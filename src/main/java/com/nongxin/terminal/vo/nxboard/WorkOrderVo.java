package com.nongxin.terminal.vo.nxboard;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.crop.CropBatch;
import com.nongxin.terminal.entity.plant.FarmingItem;
import com.nongxin.terminal.entity.plant.OrderContent;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderTypeEnum;

import com.nongxin.terminal.util.enumUtil.solar.SolarTermsEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class WorkOrderVo {

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

    private CropBatch cropBatch;

    private FarmingItem farmingItem;

    private String remark;

    private Integer farmingId;

    private OrderContent orderContent;

    private Date examineTime;

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

    public CropBatch getCropBatch() {
        return cropBatch;
    }

    public void setCropBatch(CropBatch cropBatch) {
        this.cropBatch = cropBatch;
    }

    public FarmingItem getFarmingItem() {
        return farmingItem;
    }

    public void setFarmingItem(FarmingItem farmingItem) {
        this.farmingItem = farmingItem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFarmingId() {
        return farmingId;
    }

    public void setFarmingId(Integer farmingId) {
        this.farmingId = farmingId;
    }

    public OrderContent getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(OrderContent orderContent) {
        this.orderContent = orderContent;
    }

    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }
}
