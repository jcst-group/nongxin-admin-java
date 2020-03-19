package com.nongxin.terminal.dao.file;

import com.nongxin.terminal.entity.file.PictureInfo;

import java.util.List;

public interface PictureInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PictureInfo record);

    int insertSelective(PictureInfo record);

    PictureInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PictureInfo record);

    int updateByPrimaryKey(PictureInfo record);

    int deleteByRelation(Integer relationId,Integer relationType);

    List<PictureInfo> selectByRelation(Integer relationId,Integer relationType);

    //获取用户头像图片
    PictureInfo getUserHeadPic(Integer relationId);

    //获取用户户口本图片
    PictureInfo getUserHuKOuPic(Integer relationId);

    //获取用户身份证图片
    PictureInfo getIdentifyCodePic(Integer relationId);

    //获取基地图片
    List<PictureInfo> getBasePic(Integer relationId);

    //获取土壤检测图片
    PictureInfo getSoilPic(Integer relationId);

    //获取大气检测图片
    PictureInfo getAirPic(Integer relationId);

    //获取水源检测图片
    PictureInfo getWaterPic(Integer relationId);

    //获取作物图片
    List<PictureInfo> getCropPic(Integer relationId);

    //获取食用价值图片
    List<PictureInfo> getEdiblePic(Integer relationId);

    //获取药用图片
    List<PictureInfo> getMedicinalPic(Integer relationId);

    //获取农事项目指导图片
    List<PictureInfo> getFarmingItemPic(Integer relationId);

    //获取物料信息检测图片
    PictureInfo getMaterialInfoPic(Integer relationId);

    //获取巡视反馈图片
    List<PictureInfo> getFeedBackPic(Integer relationId);

    //获取工单图片
    List<PictureInfo> getOrderPic(Integer relationId);

    //获取种子/种苗检测图片
    PictureInfo getSeedDetectionPic(Integer relationId);

    //获取种子/种苗检测报告图片
    PictureInfo getSeedDetectionResultPic(Integer relationId);

    //获取采收检测图片
    PictureInfo getRecDetectionPic(Integer relationId);

    //获取采收检测结果图片
    PictureInfo getRecDetectionResultPic(Integer relationId);

    //获取初加工检测图片
    PictureInfo getInitProDetectionPic(Integer relationId);

    //获取公司管理模式图片
    PictureInfo getManagerPic(Integer relationId);

    //获取公司荣誉模式图片
    PictureInfo getHonorPic(Integer relationId);

    //获取公司简介图片
    PictureInfo getCompanyPic(Integer relationId);

    //获取溯源药材图片
    List<PictureInfo> getProCropPic(Integer relationId);

    //获取溯源食用价值图片
    PictureInfo getProEdiblePic(Integer relationId);

    //获取溯源药用价值图片
    PictureInfo getProMedicinalPic(Integer relationId);

    //获取地块图片
    List<PictureInfo> getLotPic(Integer relationId);

    //获取病虫害反馈
    List<PictureInfo> getIllFeedbackPic(Integer relationId);

    //获取病虫害图片
    List<PictureInfo> getIllPic(Integer relationId);

    //获取指导方法图片
    List<PictureInfo> getTreatmentPic(Integer relationId);

    //获取文章图片
    List<PictureInfo> getArticlePic(Integer relationId);

    //获取预期愿景图片
    PictureInfo getExpectPic(Integer relationId);

    //获取农残图片
    PictureInfo getPesticideResiduesPic(Integer relationId);

    //获取糖度图片
    PictureInfo getSugarContentPic(Integer relationId);

    //获取果品图片
    PictureInfo getFruitReportPic(Integer relationId);
}