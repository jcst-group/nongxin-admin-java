package com.nongxin.terminal.util.enumUtil.system;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ThemeEnum implements IEnum<Short> {

    INCOMPLETE(new Short("1"),"INCOMPLETE","未完成"),
    COMPLETED(new Short("2"),"COMPLETED","已完成");

    private Short value;
    private String code;
    private String displayName;

    ThemeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static ThemeEnum getByValue(Short value){
        ThemeEnum userStatusEnums[] = ThemeEnum.values();
        for(ThemeEnum userStatusEnum : userStatusEnums){
            if(userStatusEnum.getValue().equals(value)){
                return userStatusEnum;
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
