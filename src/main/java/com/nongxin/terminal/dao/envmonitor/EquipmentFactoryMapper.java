package com.nongxin.terminal.dao.envmonitor;

import com.nongxin.terminal.entity.envmonitor.EquipmentFactory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 设备厂商表 Mapper 接口
 * </p>
 *
 * @author nongxin
 * @since 2019-11-04
 */
public interface EquipmentFactoryMapper extends BaseMapper<EquipmentFactory> {

    //获取厂商设备的具有的采集要素
    String getItem(Integer id);
}
