package com.nongxin.terminal.util.enumUtil.cms;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ArticleStatusEnum implements IEnum<Integer> {

    SHOW(1,"展示"),
    NOSHOW(2,"不展示");

    private Integer value;
    private String displayName;

    ArticleStatusEnum(Integer value,String displayName) {
        this.value = value;
        this.displayName = displayName;
    }

    public static ArticleStatusEnum getByValue(Short value){
        ArticleStatusEnum baseTypeEnums[] = ArticleStatusEnum.values();
        for(ArticleStatusEnum baseTypeEnum : baseTypeEnums){
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
