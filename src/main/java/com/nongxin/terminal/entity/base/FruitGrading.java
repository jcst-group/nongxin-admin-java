package com.nongxin.terminal.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import com.nongxin.terminal.util.enumUtil.base.FruitColorEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author nongxin
 * @since 2019-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("nx_fruit_grading")
public class FruitGrading implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 果品评分id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 果实颜色
     */
    private FruitColorEnum fruitColor;

    /**
     * 果实形状
     */
    private Double fruitShape;

    /**
     * 果肉饱满度
     */
    private Double fruitPlumpness;

    /**
     * 基地id
     */
    private Integer baseId;


}
