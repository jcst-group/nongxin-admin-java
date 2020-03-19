package com.nongxin.terminal.service.company.impl;

import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.entity.company.CompanyExpect;
import com.nongxin.terminal.dao.company.CompanyExpectMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.service.company.CompanyExpectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.util.ImgUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author nongxin
 * @since 2019-10-29
 */
@Service
public class CompanyExpectServiceImpl extends ServiceImpl<CompanyExpectMapper, CompanyExpect> implements CompanyExpectService {

    @Autowired
    private CompanyExpectMapper companyExpectMapper;
    @Autowired(required = false)
    private ImgUpload imgUpload;
    @Autowired
    private PictureInfoMapper pictureInfoMapper;

    @Override
    public List<CompanyExpect> getCompanyExpect(Integer companyId) {
        return companyExpectMapper.getCompanyExpect(companyId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(CompanyExpect companyExpect) {
        int count = companyExpectMapper.insert(companyExpect);
        PictureInfo pictureInfo = companyExpect.getPictureInfo();
        pictureInfo.setRelationId(companyExpect.getId());
        pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
        return count==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        PictureInfo expectPic = pictureInfoMapper.getExpectPic(id);
        if (expectPic != null){
            File pictureInfoFile = new File(imgUpload.getPath(expectPic.getPictureUrl()));
            pictureInfoFile.delete();
            pictureInfoMapper.deleteByPrimaryKey(expectPic.getId());
        }
        return companyExpectMapper.deleteById(id)==1;
    }

    @Override
    public boolean update(CompanyExpect companyExpect) {
        PictureInfo pictureInfo = companyExpect.getPictureInfo();
        if (pictureInfo != null){
            pictureInfo.setRelationId(companyExpect.getId());
            pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
        }
        return companyExpectMapper.updateById(companyExpect)==1;
    }
}
