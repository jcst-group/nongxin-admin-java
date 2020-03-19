package com.nongxin.terminal.vo.workorder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.plant.DeviceAct;
import com.nongxin.terminal.entity.plant.FarmingItem;
import com.nongxin.terminal.entity.plant.MaterialAct;
import com.nongxin.terminal.entity.plant.PersonnelAct;
import com.nongxin.terminal.util.enumUtil.plan.WorkOrderStatusEnum;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class AppOrderVo {

    private Integer id;

    private String batchName;

    private String baseName;

    private String remark;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date executionTime;

    private FarmingItem farmingItem;

    private List<DeviceAct> deviceActList;

    private List<MaterialAct> materialActList;

    private List<PersonnelAct> personnelActList;

    private WorkOrderStatusEnum status;

    //提交时间
    private Date subTime;

    //审核时间
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

    public WorkOrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(WorkOrderStatusEnum status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    public FarmingItem getFarmingItem() {
        return farmingItem;
    }

    public void setFarmingItem(FarmingItem farmingItem) {
        this.farmingItem = farmingItem;
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
}
