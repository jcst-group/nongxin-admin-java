package com.nongxin.terminal.entity.cms;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * 
 * </p>
 *
 * @author test
 * @since 2019-10-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nx_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 类别id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类别
     */
    @NotEmpty(message = "类别名称不能为空")
    private String category;

    /**
     * 父级
     */
    @NotNull(message = "父级不能为空")
    private Integer parentId;

    /**
     * 状态 1:展示  2:不展示
     */
    private Integer status;


}
