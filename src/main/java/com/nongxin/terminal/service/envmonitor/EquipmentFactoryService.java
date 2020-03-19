package com.nongxin.terminal.service.envmonitor;

import com.nongxin.terminal.entity.envmonitor.EquipmentFactory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 设备厂商表 服务类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-04
 */
public interface EquipmentFactoryService extends IService<EquipmentFactory> {

    String getItem(Integer id);
}
