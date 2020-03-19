package com.nongxin.terminal.util.enumUtil.seed;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum SeedTypeEnum implements IEnum<Short> {

    SEED(new Short("1"),"SEED","种子"),
    SEEDLING(new Short("2"),"SEEDLING","种苗");

    private Short value;
    private String code;
    private String displayName;

    SeedTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static SeedTypeEnum getByValue(Short value){
        SeedTypeEnum baseTypeEnums[] = SeedTypeEnum.values();
        for(SeedTypeEnum baseTypeEnum : baseTypeEnums){
            if(baseTypeEnum.getValue().equals(value)){
                return baseTypeEnum;
            }
        }
        return null;
    }

    public Short getValue() {
        return value;
    }

    public String getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

}
