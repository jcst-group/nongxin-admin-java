package com.nongxin.terminal.controller.backstage.cms;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nongxin.terminal.entity.cms.Article;
import com.nongxin.terminal.service.cms.ArticleService;
import com.nongxin.terminal.util.enumUtil.cms.ArticleStatusEnum;
import com.nongxin.terminal.vo.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    @ApiOperation("分页带条件查询所有文章")
    public Result getAccount(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                             @RequestParam(name = "pageSize" ,defaultValue = "10") Integer pageSize,
                             Article article){
        Result result = new Result();
        Page<Article> page = new Page<>(pageNo,pageSize);
        result.setSuccessResult(articleService.getArticle(page,article));
        return result;
    }

    @GetMapping("/delete")
    @ApiOperation("删除文章")
    public Result delete(Integer id){
        Result result = new Result();
        boolean isSuccess = articleService.delete(id);
        if (isSuccess){
            result.setMessage("删除文章成功");
        }else{
            result.setMessage("删除文章失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/add")
    @ApiOperation("添加文章")
    public Result add(@Validated @RequestBody Article article){
        Result result = new Result();
        article.setStatus(ArticleStatusEnum.SHOW);
        boolean isSuccess = articleService.add(article);
        if (isSuccess){
            result.setMessage("添加文章成功");
        }else{
            result.setMessage("添加文章失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @PostMapping("/update")
    @ApiOperation("修改文章")
    public Result update(@RequestBody Article article){
        Result result = new Result();
        boolean isSuccess = articleService.update(article);
        if (isSuccess){
            result.setMessage("修改文章成功");
        }else{
            result.setMessage("修改文章失败");
        }
        result.setSuccess(isSuccess);
        return result;
    }

    @GetMapping("/selectById")
    @ApiOperation("根据id查询文章")
    public Result<Article> selectById(@RequestParam(required = true)Integer id){
        Result<Article> result = new Result<>();
        result.setSuccessResult(articleService.selectById(id));
        return result;
    }

}
