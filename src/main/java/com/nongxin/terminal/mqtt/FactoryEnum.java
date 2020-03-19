package com.nongxin.terminal.mqtt;

public enum FactoryEnum {


    SANCHUAN(1,"三川"),
    DAQIHOU(2,"大气候"),
    SAITONG(3,"赛通");
    private Integer factoryId;

    private String FactoryName;

    FactoryEnum(Integer factoryId, String factoryName) {
        this.factoryId = factoryId;
        FactoryName = factoryName;
    }

    public Integer getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(Integer factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return FactoryName;
    }

    public void setFactoryName(String factoryName) {
        FactoryName = factoryName;
    }

    /*public String toString() {
        return this.factoryId;
    }*/


}
