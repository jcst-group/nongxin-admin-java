package com.nongxin.terminal.entity.company;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.nongxin.terminal.entity.file.PictureInfo;
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
 * @author nongxin
 * @since 2019-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nx_company_expect")
public class CompanyExpect implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预期id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 预期
     */
    @NotEmpty(message = "预期不能为空")
    private String expect;

    @NotNull(message = "公司id不能为空")
    private Integer companyId;

    @NotNull(message = "图标不能为空")
    @TableField(exist = false)
    private PictureInfo pictureInfo;


}
