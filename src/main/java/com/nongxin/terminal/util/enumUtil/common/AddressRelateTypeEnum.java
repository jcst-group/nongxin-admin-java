package com.nongxin.terminal.util.enumUtil.common;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AddressRelateTypeEnum implements IEnum<Short> {

    BASE_ADDRESS(new Short("1"),"BASE_ADDRESS","基地地址"),
    LOT_ADDRESS(new Short("2"),"LOT_ADDRESS","地块地址");

    private Short value;
    private String code;
    private String displayName;

    AddressRelateTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static AddressRelateTypeEnum getByValue(Short value){
        AddressRelateTypeEnum addressRelateTypeEnums[] = AddressRelateTypeEnum.values();
        for(AddressRelateTypeEnum addressRelateTypeEnum : addressRelateTypeEnums){
            if(addressRelateTypeEnum.getValue().equals(value)){
                return addressRelateTypeEnum;
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
