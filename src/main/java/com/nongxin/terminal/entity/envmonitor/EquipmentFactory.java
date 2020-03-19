package com.nongxin.terminal.entity.envmonitor;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 设备厂商表
 * </p>
 *
 * @author nongxin
 * @since 2019-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ddwb_equipment_factory")
public class EquipmentFactory implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 设备厂商名称
     */
    private String factoryName;

    /**
     * 厂商售后联系人
     */
    private String contactMan;

    /**
     * 售后电话
     */
    private String phone;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 采集要素项
     */
    private String item;


}
