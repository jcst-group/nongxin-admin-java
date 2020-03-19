package com.nongxin.terminal.entity.plant;

import javax.validation.constraints.NotEmpty;

public class CalculateUnit {
    private Integer id;

    @NotEmpty(message = "计量单位不能为空")
    private String unit;

    @NotEmpty(message = "物料计量单位不能为空")
    private String materialUnit;

    @NotEmpty(message = "人员计量单位不能为空")
    private String personnelUnit;

    @NotEmpty(message = "设备计量单位不能为空")
    private String deviceUnit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(String materialUnit) {
        this.materialUnit = materialUnit == null ? null : materialUnit.trim();
    }

    public String getPersonnelUnit() {
        return personnelUnit;
    }

    public void setPersonnelUnit(String personnelUnit) {
        this.personnelUnit = personnelUnit == null ? null : personnelUnit.trim();
    }

    public String getDeviceUnit() {
        return deviceUnit;
    }

    public void setDeviceUnit(String deviceUnit) {
        this.deviceUnit = deviceUnit == null ? null : deviceUnit.trim();
    }
}