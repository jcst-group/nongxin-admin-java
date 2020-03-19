package com.nongxin.terminal.util.enumUtil.detection;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DetectionUnitEnum implements IEnum<Short> {
    MPN((short)1,"MPN","MPN/100ml"),
    CFU((short)2,"CFU","CFU/ml"),
    MGL((short)3,"MGL","mg/L"),
    MGM3((short)4,"MGM3","mg/m3"),
    UGM3((short)5,"UGM3","ug/m3"),
    MGKG((short)6,"MGKG","mg/kg"),
    CMOLKG((short)7,"CMOLKG","cmol(+)/kg"),
    PERCENT((short)8,"PERCENT","%"),
    PERCENTMLG((short)9,"PERCENTMLG","%(ml/g)"),
    GRAM((short)10,"GRAM","g"),
    KILOGRAM((short)11,"KILOGRAM","kg"),
    PPM((short)12,"PPM","ppm"),
    TEMPERATURE((short)13,"TEMPERATURE","℃"),
    G100G((short)14,"G100G","g/100g"),
    G100GRAIN((short)15,"G100GRAIN","g/100粒"),
    GRAIN50G((short)16,"GRAIN50G","粒/50g"),
    PERL((short)17,"PERL","个/L"),
    PERML((short)18,"PERML","个/mL"),
    MGM2((short)19,"MGM2","mg/m²"),
    GKG((short)20,"GKG","g/Kg"),
    PER((short)21,"PER","个"),
    CM((short)22,"CM","cm"),
    DAY((short)23,"DAY","天");

    private Short value;
    private String code;
    private String displayName;

    DetectionUnitEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static DetectionUnitEnum getByValue(Short value){
        DetectionUnitEnum envStandardsEnums[] = DetectionUnitEnum.values();
        for(DetectionUnitEnum e : envStandardsEnums){
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
