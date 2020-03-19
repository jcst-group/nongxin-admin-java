package com.nongxin.terminal.util.enumUtil.system;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ConstantTypeEnum implements IEnum<Short> {

    TRACEABILITY(new Short("1"),"TRACEABILITY","溯源地址"),
    IMG_ADDRESS(new Short("2"),"IMG_ADDRESS","图片地址");

    private Short value;
    private String code;
    private String displayName;

    ConstantTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static ConstantTypeEnum getByValue(Short value){
        ConstantTypeEnum userSexEnums[] = ConstantTypeEnum.values();
        for(ConstantTypeEnum userSexEnum : userSexEnums){
            if(userSexEnum.getValue().equals(value)){
                return userSexEnum;
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
