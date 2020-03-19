package com.nongxin.terminal.service.order.impl;

import com.nongxin.terminal.dao.order.OrderInfoMapper;
import com.nongxin.terminal.entity.order.OrderInfo;
import com.nongxin.terminal.service.order.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public boolean insert(OrderInfo orderInfo) {
        return orderInfoMapper.insertSelective(orderInfo) == 1;
    }

    @Override
    public List<OrderInfo> getAllList() {
        return orderInfoMapper.getAllList();
    }
}
