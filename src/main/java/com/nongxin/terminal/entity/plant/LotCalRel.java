package com.nongxin.terminal.entity.plant;

import javax.validation.constraints.NotNull;

public class LotCalRel {
    private Integer id;

    @NotNull(message = "地块不能为空")
    private Integer lotId;

    @NotNull(message = "计量单位不能为空")
    private Integer calId;

    @NotNull(message = "规模不能为空")
    private Long scale;

    @NotNull(message = "作物不能为空")
    private Integer cropId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public Long getScale() {
        return scale;
    }

    public void setScale(Long scale) {
        this.scale = scale;
    }

    public Integer getCropId() {
        return cropId;
    }

    public void setCropId(Integer cropId) {
        this.cropId = cropId;
    }
}