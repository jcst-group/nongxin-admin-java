package com.nongxin.terminal.service.base.impl;

import com.nongxin.terminal.dao.address.AddressMapper;
import com.nongxin.terminal.dao.base.BaseInfoMapper;
import com.nongxin.terminal.dao.base.BaseTestingMapper;
import com.nongxin.terminal.dao.base.FruitGradingMapper;
import com.nongxin.terminal.dao.base.SugarContentMapper;
import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.entity.address.Address;
import com.nongxin.terminal.entity.base.BaseInfo;
import com.nongxin.terminal.entity.base.FruitGrading;
import com.nongxin.terminal.entity.base.SugarContent;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.service.base.BaseInfoService;
import com.nongxin.terminal.service.base.FruitGradingService;
import com.nongxin.terminal.service.base.SugarContentService;
import com.nongxin.terminal.service.crop.CropBatchService;
import com.nongxin.terminal.util.ImgUpload;
import com.nongxin.terminal.util.enumUtil.base.BaseTypeEnum;
import com.nongxin.terminal.util.enumUtil.base.CategoryEnum;
import com.nongxin.terminal.util.enumUtil.base.EnvStandardsEnum;
import com.nongxin.terminal.util.enumUtil.common.AddressRelateTypeEnum;
import com.nongxin.terminal.vo.TreeNodeVo;
import com.nongxin.terminal.vo.lookboard.BaseInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.util.*;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    @Autowired(required = false)
    private BaseInfoMapper baseInfoMapper;
    @Autowired(required = false)
    private BaseTestingMapper baseTestingMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired(required = false)
    private AddressMapper addressMapper;
    @Autowired
    private ImgUpload imgUpload;
    @Autowired
    private SugarContentMapper sugarContentMapper;
    @Autowired
    private CropBatchService cropBatchService;
    @Autowired
    private FruitGradingMapper fruitGradingMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(BaseInfo baseInfo) {
        try {
            baseInfoMapper.insertSelective(baseInfo);
            if (baseInfo.getBaseTestingVoList()!=null && !baseInfo.getBaseTestingVoList().isEmpty()){
                baseTestingMapper.addBaseTesting(baseInfo.getBaseTestingVoList(),baseInfo.getId());
            }

            List<SugarContent> sugarContents = baseInfo.getSugarContents();
            if (sugarContents!=null && !sugarContents.isEmpty()){
                sugarContentMapper.addSugarContent(sugarContents,baseInfo.getId());
            }

            FruitGrading fruitGrading = baseInfo.getFruitGrading();
            if (fruitGrading != null){
                fruitGrading.setBaseId(baseInfo.getId());
                fruitGradingMapper.insert(fruitGrading);
            }

            List<PictureInfo> basePics = baseInfo.getBasePic();
            if (basePics != null && !basePics.isEmpty()){
                for (PictureInfo basePic : basePics) {
                    basePic.setRelationId(baseInfo.getId());
                    pictureInfoMapper.updateByPrimaryKeySelective(basePic);
                }
            }

            PictureInfo soilPic = baseInfo.getSoilPic();
            soilPic.setRelationId(baseInfo.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(soilPic);

            PictureInfo airPic = baseInfo.getAirPic();
            airPic.setRelationId(baseInfo.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(airPic);

            PictureInfo waterPic = baseInfo.getWaterPic();
            waterPic.setRelationId(baseInfo.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(waterPic);

            PictureInfo pesticideResiduesPic = baseInfo.getPesticideResiduesPic();
            if (pesticideResiduesPic!=null){
                pesticideResiduesPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pesticideResiduesPic);
            }

            PictureInfo sugarContentPic = baseInfo.getSugarContentPic();
            if (sugarContentPic!=null){
                sugarContentPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(sugarContentPic);
            }

            PictureInfo fruitReportPic = baseInfo.getFruitReportPic();
            if (fruitReportPic!=null){
                fruitReportPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(fruitReportPic);
            }

            Address address = baseInfo.getAddress();
            address.setRelateId(baseInfo.getId());
            address.setRelateType(AddressRelateTypeEnum.BASE_ADDRESS);
            addressMapper.insertSelective(address);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> basePics = pictureInfoMapper.getBasePic(id);
        if (basePics != null && !basePics.isEmpty()){
            for (PictureInfo basePic : basePics) {
                File file = new File(imgUpload.getPath(basePic.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(basePic.getId());
            }
        }
        PictureInfo oldAirPic = pictureInfoMapper.getAirPic(id);
        if (oldAirPic != null){
            File file = new File(imgUpload.getPath(oldAirPic.getPictureUrl()));
            file.delete();
            pictureInfoMapper.deleteByPrimaryKey(oldAirPic.getId());
        }
        PictureInfo oldWaterPic = pictureInfoMapper.getWaterPic(id);
        if (oldWaterPic != null){
            File file = new File(imgUpload.getPath(oldWaterPic.getPictureUrl()));
            file.delete();
            pictureInfoMapper.deleteByPrimaryKey(oldWaterPic.getId());
        }
        PictureInfo oldSoilPic = pictureInfoMapper.getSoilPic(id);
        if (oldSoilPic != null){
            File file = new File(imgUpload.getPath(oldSoilPic.getPictureUrl()));
            file.delete();
            pictureInfoMapper.deleteByPrimaryKey(oldSoilPic.getId());
        }

        PictureInfo pesticideResiduesPic = pictureInfoMapper.getPesticideResiduesPic(id);
        if (pesticideResiduesPic != null){
            File file = new File(imgUpload.getPath(pesticideResiduesPic.getPictureUrl()));
            file.delete();
            pictureInfoMapper.deleteByPrimaryKey(pesticideResiduesPic.getId());
        }

        PictureInfo sugarContentPic = pictureInfoMapper.getSugarContentPic(id);
        if (sugarContentPic != null){
            File file = new File(imgUpload.getPath(sugarContentPic.getPictureUrl()));
            file.delete();
            pictureInfoMapper.deleteByPrimaryKey(sugarContentPic.getId());
        }

        return baseInfoMapper.deleteByPrimaryKey(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(BaseInfo baseInfo) {
        try {
            baseInfoMapper.updateByPrimaryKeySelective(baseInfo);
            Address address = baseInfo.getAddress();
            if (address != null){
                address.setRelateId(baseInfo.getId());
                address.setRelateType(AddressRelateTypeEnum.BASE_ADDRESS);
                addressMapper.updateByPrimaryKeySelective(address);
            }
            if (baseInfo.getBaseTestingVoList()!=null && !baseInfo.getBaseTestingVoList().isEmpty()){
                baseTestingMapper.deleteByBaseId(baseInfo.getId());
                baseTestingMapper.addBaseTesting(baseInfo.getBaseTestingVoList(),baseInfo.getId());
            }

            Map<String,Object> map = new HashMap<>();
            map.put("base_id",baseInfo.getId());

            List<SugarContent> sugarContents = baseInfo.getSugarContents();
            sugarContentMapper.deleteByMap(map);
            if (sugarContents!=null && !sugarContents.isEmpty()){
                sugarContentMapper.addSugarContent(sugarContents,baseInfo.getId());
            }

            FruitGrading fruitGrading = baseInfo.getFruitGrading();
            fruitGradingMapper.deleteByMap(map);
            if (fruitGrading != null){
                fruitGrading.setBaseId(baseInfo.getId());
                fruitGradingMapper.insert(fruitGrading);
            }

            List<PictureInfo> basePics = baseInfo.getBasePic();
            if (basePics != null && !basePics.isEmpty()){
                for (PictureInfo basePic : basePics) {
                    basePic.setRelationId(baseInfo.getId());
                    pictureInfoMapper.updateByPrimaryKeySelective(basePic);
                }
            }

            PictureInfo soilPic = baseInfo.getSoilPic();
            if (soilPic!=null){
                soilPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(soilPic);
            }

            PictureInfo airPic = baseInfo.getAirPic();
            if (airPic!=null){
                airPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(airPic);
            }

            PictureInfo waterPic = baseInfo.getWaterPic();
            if (waterPic!=null){
                waterPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(waterPic);
            }

            PictureInfo pesticideResiduesPic = baseInfo.getPesticideResiduesPic();
            if (pesticideResiduesPic!=null){
                pesticideResiduesPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pesticideResiduesPic);
            }

            PictureInfo sugarContentPic = baseInfo.getSugarContentPic();
            if (sugarContentPic!=null){
                sugarContentPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(sugarContentPic);
            }

            PictureInfo fruitReportPic = baseInfo.getFruitReportPic();
            if (fruitReportPic!=null){
                fruitReportPic.setRelationId(baseInfo.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(fruitReportPic);
            }

            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return false;
    }

    @Override
    public List<BaseInfo> getBaseInfoList(BaseInfo baseInfo) {
        return baseInfoMapper.getBaseInfoList(baseInfo);
    }

    @Override
    public List<BaseInfo> getAllBaseInfo(CategoryEnum category, BaseTypeEnum baseType, String baseName) {
        return baseInfoMapper.getAllBaseInfo(category,baseType,baseName);
    }

    @Override
    public List<BaseInfo> getBaseByType(Integer baseType) {
        return baseInfoMapper.getBaseByType(baseType);
    }

    @Override
    public List<BaseInfo> getBaseWithoutUser() {
        return baseInfoMapper.getBaseWithoutUser();
    }

    @Override
    public BaseInfo selectByPrimaryKey(Integer id) {
        return baseInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public BaseInfoVo getBaseInfoById(Integer baseId) {
        return baseInfoMapper.getBaseInfoById(baseId);
    }

    @Override
    public List<TreeNodeVo> getBaseTreeByUid(Integer uid) {
        return baseInfoMapper.getBaseTreeByUid(uid);
    }

    @Override
    public List<BaseInfo> getBaseEquipment() {
        return baseInfoMapper.getBaseEquipment();
    }

    @Override
    public Map<String, Object> getBoardPesticideResidues(Integer baseId, EnvStandardsEnum type) {
        Map<String, Object> map = new HashMap<>();
        map.put("pictureInfo",pictureInfoMapper.getPesticideResiduesPic(baseId));
        map.put("pesticideResidues",baseTestingMapper.selectByBaseIdAndType(baseId,type));
        return map;
    }

    @Override
    public BaseInfo getPanoramaUrl(Integer id) {
        return baseInfoMapper.getPanoramaUrl(id);
    }

    @Override
    public List<PictureInfo> getBaseDetectionPic(String retroCode,Integer batchId) {
        Integer baseId = null;
        if (retroCode != null){
            baseId = baseInfoMapper.getIdByRetroCode(retroCode);
        }else{
            baseId = cropBatchService.selectByPrimaryKey(batchId).getBaseId();
        }
        List<PictureInfo> list = new ArrayList<>();
        list.add(pictureInfoMapper.getSoilPic(baseId));
        list.add(pictureInfoMapper.getWaterPic(baseId));
        list.add(pictureInfoMapper.getAirPic(baseId));
        list.add(pictureInfoMapper.getPesticideResiduesPic(baseId));
        list.add(pictureInfoMapper.getSugarContentPic(baseId));
        list.removeAll(Collections.singleton(null));
        return list;
    }

    @Override
    public Map<String, Object> getLongitudeById(Integer id) {
        return baseInfoMapper.getLongitudeById(id);
    }

    @Override
    public BaseInfo getBaseById(Integer id) {
        return baseInfoMapper.getBaseById(id);
    }

    @Override
    public List<Map<String, Object>> getBaseByUid(Integer uid) {
        return baseInfoMapper.getBaseByUid(uid);
    }

}
