package com.nongxin.terminal.dao.cms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.cms.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper extends BaseMapper<Article> {

    IPage<Article> getArticle(Page<Article> page, @Param("article") Article article);

    Article selectById(Integer id);

}
