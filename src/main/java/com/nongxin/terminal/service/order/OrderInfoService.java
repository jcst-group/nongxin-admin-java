package com.nongxin.terminal.service.order;

import com.nongxin.terminal.entity.order.OrderInfo;

import java.util.List;

public interface OrderInfoService {

    boolean insert(OrderInfo orderInfo);

    List<OrderInfo> getAllList();
}
