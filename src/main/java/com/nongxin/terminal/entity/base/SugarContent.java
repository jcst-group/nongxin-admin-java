package com.nongxin.terminal.entity.base;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

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
@TableName("nx_sugar_content")
public class SugarContent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 糖度id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 糖度
     */
    private Double sugarContent;

    /**
     * 基地id
     */
    private Integer baseId;

    /**
     * 检测时间
     */
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date detectionTime;


}
