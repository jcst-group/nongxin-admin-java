package com.nongxin.terminal.util.enumUtil.base;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FruitColorEnum implements IEnum<Integer> {

    CYAN(1,"青"),
    SALLOW(2,"青黄"),
    LIGHT_YELLOW(3,"淡黄"),
    YELLOW(4,"黄");

    private Integer value;
    private String displayName;

    FruitColorEnum(Integer value, String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static FruitColorEnum getByValue(Short value){
        FruitColorEnum baseTypeEnums[] = FruitColorEnum.values();
        for(FruitColorEnum baseTypeEnum : baseTypeEnums){
            if(baseTypeEnum.getValue().equals(value)){
                return baseTypeEnum;
            }
        }
        return null;
    }

    public Integer getValue() {
        return value;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

}
