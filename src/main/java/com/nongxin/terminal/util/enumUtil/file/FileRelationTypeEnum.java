package com.nongxin.terminal.util.enumUtil.file;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FileRelationTypeEnum implements IEnum<Short> {

    TASK(new Short("1"),"TASK","任务文件"),
    MATERIALINFO(new Short("2"),"MATERIALINFO","物料信息文件"),
    WORKORDER(new Short("3"),"WORKORDER","工单音频"),
    VIDEOCOMPANY(new Short("4"),"VIDEOCOMPANY","公司介绍视频"),
    VIDEOPRODUCT(new Short("5"),"VIDEOPRODUCT","产品介绍视频");

    private Short value;
    private String code;
    private String displayName;

    FileRelationTypeEnum(Short value, String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static FileRelationTypeEnum getByValue(Short value){
        FileRelationTypeEnum imgRelationTypeEnums[] = FileRelationTypeEnum.values();
        for(FileRelationTypeEnum imgRelationTypeEnum : imgRelationTypeEnums){
            if(imgRelationTypeEnum.getValue().equals(value)){
                return imgRelationTypeEnum;
            }
        }
        return null;
    }


    @Override
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
