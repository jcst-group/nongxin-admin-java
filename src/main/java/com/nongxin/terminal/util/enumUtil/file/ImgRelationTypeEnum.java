package com.nongxin.terminal.util.enumUtil.file;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ImgRelationTypeEnum implements IEnum<Short> {

    BASE(new Short("1"),"BASE","基地照片"),
    WATER(new Short("2"),"WATER","水源检测图片"),
    AIR(new Short("3"),"AIR","空气检测图片"),
    SOIL(new Short("4"),"SOIL","土壤检测图片"),
    CROP(new Short("5"),"CROP","作物"),
    EDIBLE_VALUE(new Short("6"),"EDIBLE_VALUE","食用价值"),
    MEDICINAL_VALUE(new Short("7"),"MEDICINAL_VALUE","药用价值"),
    SEED_DETECTION(new Short("8"),"SEED_DETECTION","种子检测图片"),
    FARMING_ITEM(new Short("9"),"FARMING_ITEM","农事项目指导图片"),
    RECOVERY_DETECTION(new Short("10"),"RECOVERY_DETECTION","采收检测"),
    USER_HEAD(new Short("11"),"USER_HEAD","用户头像图片"),
    USER_HUKOU(new Short("12"),"USER_HUKOU","用户户口本图片"),
    IDENTIFY_CODE(new Short("13"),"IDENTIFY_CODE","用户身份证图片"),
    MATERIALINFO(new Short("14"),"MATERIALINFO","物料信息检测图片"),
    FEEDBACK(new Short("15"),"FEEDBACK","巡视反馈图片"),
    WORKORDER(new Short("16"),"WORKORDER","工单图片"),
    SEED_DETECTION_RESULT(new Short("17"),"SEED_DETECTION_RESULT","种子检测结果图片"),
    RECOVERY_DETECTION_RESULT(new Short("18"),"RECOVERY_DETECTION_RESULT","采收检测结果图片"),
    INITPRO_DETECTION(new Short("19"),"INITPRO_DETECTION","初加工检测图片"),
    COMPANY_MANAGER(new Short("20"),"COMPANY_MANAGER","公司管理模式图"),
    COMPANY_HONOR(new Short("21"),"COMPANY_HONOR","公司荣誉模式图"),
    PRO_CROP(new Short("22"),"PRO_CROP","溯源药材图片"),
    PRO_EDIBLE_VALUE(new Short("23"),"PRO_EDIBLE_VALUE","溯源食用价值"),
    PRO_MEDICINAL_VALUE(new Short("24"),"PRO_MEDICINAL_VALUE","溯源药用价值"),
    COMPANY_PROFILE(new Short("25"),"COMPANY_PROFILE","公司简介图"),
    LOT(new Short("26"),"LOT","地块图片"),
    ILL_FEEDBACK(new Short("27"),"ILL_FEEDBACK","病虫害反馈图片"),
    ILL(new Short("28"),"ILL","病虫害图片"),
    TREATMENT_GUI(new Short("29"),"TREATMENT_GUI","病虫害治疗指导图片"),
    ARTICLE(new Short("30"),"ARTICLE","文章图片"),
    EXPECT(new Short("31"),"EXPECT","预期愿景图片"),
    PESTICIDE_RESIDUES(new Short("32"),"PESTICIDE_RESIDUES","农残图片"),
    BRIX(new Short("33"),"BRIX","糖度图片"),
    FRUIT_REPORT(new Short("34"),"FRUIT_REPORT","果品报告图片");

    private Short value;
    private String code;
    private String displayName;

    ImgRelationTypeEnum(Short value,String code, String displayName) {
        this.value = value;
        this.code = code;
        this.displayName = displayName;
    }

    public static ImgRelationTypeEnum getByValue(Short value){
        ImgRelationTypeEnum imgRelationTypeEnums[] = ImgRelationTypeEnum.values();
        for(ImgRelationTypeEnum imgRelationTypeEnum : imgRelationTypeEnums){
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
