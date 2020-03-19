package com.nongxin.terminal.service.envmonitor.impl;

import com.nongxin.terminal.entity.envmonitor.EquipmentFactory;
import com.nongxin.terminal.dao.envmonitor.EquipmentFactoryMapper;
import com.nongxin.terminal.service.envmonitor.EquipmentFactoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备厂商表 服务实现类
 * </p>
 *
 * @author nongxin
 * @since 2019-11-04
 */
@Service
public class EquipmentFactoryServiceImpl extends ServiceImpl<EquipmentFactoryMapper, EquipmentFactory> implements EquipmentFactoryService {

    @Autowired
    private EquipmentFactoryMapper equipmentFactoryMapper;

    @Override
    public String getItem(Integer id) {
        return equipmentFactoryMapper.getItem(id).replaceAll("\"","");
    }
}
