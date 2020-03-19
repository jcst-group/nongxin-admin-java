package com.nongxin.terminal.dao.order;

import com.nongxin.terminal.entity.order.OrderInfo;

import java.util.List;

public interface OrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);

    List<OrderInfo> getAllList();
}