package com.nongxin.terminal.entity.cms;

import com.baomidou.mybatisplus.annotation.*;

import java.util.Date;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nongxin.terminal.entity.file.PictureInfo;
import com.nongxin.terminal.util.enumUtil.cms.ArticleStatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nx_article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类别id
     */
    @NotNull(message = "类别不能为空")
    private Integer categoryId;

    /**
     * 文章标题
     */
    @NotNull(message = "标题不能为空")
    private String title;

    /**
     * 内容
     */
    @NotNull(message = "内容不能为空")
    private String content;

    /**
     * 作者
     */
    private String author;

    /**
     * 引用于
     */
    private String cropFrom;

    /**
     * 转向链接
     */
    private String httpUrl;

    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 修改时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 修改人
     */
    private Date updateId;

    /**
     * 状态
     */
    private ArticleStatusEnum status;

    @TableField(exist = false)
    private Category category;

    @TableField(exist = false)
    private List<PictureInfo> pictureInfos;

}
