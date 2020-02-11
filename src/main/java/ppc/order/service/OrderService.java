package ppc.order.service;

import ppc.order.dto.OrderDTO;
import ppc.order.entity.OrderDetail;
import ppc.order.entity.OrderInfo;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO);
}
