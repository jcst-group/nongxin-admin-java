package com.nongxin.terminal.service.base;

import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.util.enumUtil.base.BaseTypeEnum;
import com.nongxin.terminal.util.enumUtil.base.CategoryEnum;
import com.nongxin.terminal.util.enumUtil.base.EnvStandardsEnum;
import com.nongxin.terminal.vo.TreeNodeVo;
import com.nongxin.terminal.vo.lookboard.BaseInfoVo;

import java.util.List;
import java.util.Map;

public interface BaseInfoService {

    boolean add(BaseInfo baseInfo);

    boolean delete(Integer id);

    boolean update(BaseInfo baseInfo);

    List<BaseInfo> getBaseInfoList(BaseInfo baseInfo);

    List<BaseInfo> getAllBaseInfo(CategoryEnum category,BaseTypeEnum baseType,String baseName);

    //根据基地类型查询基地
    List<BaseInfo> getBaseByType(Integer baseType);

    //获取无用户的基地
    List<BaseInfo> getBaseWithoutUser();

    BaseInfo selectByPrimaryKey(Integer id);

    BaseInfo getBaseById(Integer id);

    //根据用户id查询对应基地
    List<Map<String,Object>> getBaseByUid(Integer uid);

    BaseInfoVo getBaseInfoById(Integer baseId);

    //查询用户对应基地以及批次（树状结构）
    List<TreeNodeVo> getBaseTreeByUid(Integer uid);

    //查询有设备的基地
    List<BaseInfo> getBaseEquipment();

    //获取看板农残检测数据
    Map<String,Object> getBoardPesticideResidues(Integer baseId, EnvStandardsEnum type);

    //获取看板基地全景
    BaseInfo getPanoramaUrl(Integer id);

    //根据追溯码查询基地检测图片
    List<PictureInfo> getBaseDetectionPic(String retroCode,Integer batchId);

    //根据id获取经纬度
    Map<String,Object> getLongitudeById(Integer id);
}
