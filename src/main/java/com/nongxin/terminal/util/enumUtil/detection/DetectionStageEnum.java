package com.nongxin.terminal.util.enumUtil.detection;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DetectionStageEnum implements IEnum<Short> {

    SEED((short)1,"SEED","种子检测"),
    RECOVERY((short)2,"RECOVERY","采收检测"),
    INIPRO((short)3,"INIPRO","初加工检测");

    private Short value;
    private String code;
    private String displayName;

    DetectionStageEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static DetectionStageEnum getByValue(Short value){
        DetectionStageEnum detectiondisplayNameEnums[] = DetectionStageEnum.values();
        for(DetectionStageEnum e : detectiondisplayNameEnums){
            if(e.getValue().equals(value)){
                return e;
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
