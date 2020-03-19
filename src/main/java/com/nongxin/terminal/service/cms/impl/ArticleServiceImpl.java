package com.nongxin.terminal.service.cms.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.dao.file.PictureInfoMapper;
import com.nongxin.terminal.entity.cms.Article;
import com.nongxin.terminal.dao.cms.ArticleMapper;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.service.cms.ArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nongxin.terminal.util.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired(required = false)
    private ArticleMapper articleMapper;
    @Autowired(required = false)
    private PictureInfoMapper pictureInfoMapper;
    @Autowired
    private FileUpload fileUpload;

    @Override
    public IPage<Article> getArticle(Page<Article> page, Article article) {
        return articleMapper.getArticle(page,article);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean add(Article article) {
        int count = articleMapper.insert(article);
        List<PictureInfo> pictureInfos = article.getPictureInfos();
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                pictureInfo.setRelationId(article.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return count==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id) {
        List<PictureInfo> pictureInfos = pictureInfoMapper.getArticlePic(id);
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                File file = new File(fileUpload.getPath(pictureInfo.getPictureUrl()));
                file.delete();
                pictureInfoMapper.deleteByPrimaryKey(id);
            }
        }
        return articleMapper.deleteById(id)==1;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean update(Article article) {
        int count = articleMapper.updateById(article);
        List<PictureInfo> pictureInfos = article.getPictureInfos();
        if (pictureInfos != null && !pictureInfos.isEmpty()){
            for (PictureInfo pictureInfo : pictureInfos) {
                pictureInfo.setRelationId(article.getId());
                pictureInfoMapper.updateByPrimaryKeySelective(pictureInfo);
            }
        }
        return count==1;
    }

    @Override
    public Article selectById(Integer id) {
        return articleMapper.selectById(id);
    }
}
