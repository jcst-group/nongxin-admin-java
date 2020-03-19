package com.nongxin.terminal.entity.plant;

public class FarmingCalRel {
    private Integer farmingId;

    private Integer calId;

    public Integer getFarmingId() {
        return farmingId;
    }

    public void setFarmingId(Integer farmingId) {
        this.farmingId = farmingId;
    }

    public Integer getCalId() {
        return calId;
    }

    public void setCalId(Integer calId) {
        this.calId = calId;
    }

    public FarmingCalRel(Integer farmingId, Integer calId) {
        this.farmingId = farmingId;
        this.calId = calId;
    }
}