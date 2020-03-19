package com.nongxin.terminal.service.cms;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.cms.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService extends IService<Article> {

    IPage<Article> getArticle(Page<Article> page, @Param("article") Article article);

    boolean add(Article article);

    boolean delete(Integer id);

    boolean update(Article article);

    Article selectById(Integer id);

}
