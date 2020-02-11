package ppc.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ppc.order.client.ProductFeignClient;
import ppc.order.dto.CartDTO;
import ppc.order.dto.OrderDTO;
import ppc.order.entity.OrderDetail;
import ppc.order.entity.OrderInfo;
import ppc.order.entity.Product;
import ppc.order.exception.OrderException;
import ppc.order.jpa.OrderDetailJpa;
import ppc.order.jpa.OrderJpa;
import ppc.order.service.OrderService;
import ppc.order.util.KeyUtil;
import ppc.order.vo.ResultVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private OrderJpa orderJpa;

    @Autowired
    private OrderDetailJpa orderDetailJpa;
    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();
        //查询商品
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetails();
        List<OrderDetail> newOrderDetailList1 = new ArrayList<>();
        List<String> productIds = orderDetailList.stream().map(i -> i.getProductId()).collect(Collectors.toList());
        List<Product> products = productFeignClient.findByProductIds(productIds);
        //计算总价
        Double totalMoney = 0.0;
        for(OrderDetail orderDetail:orderDetailList){
            for(Product product:products){
                if(orderDetail.getProductId().equals(product.getProductId())){
                    totalMoney += orderDetail.getProductQuantity() * product.getProductPrice();
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetail.setOrderId(orderId);
                    orderDetail.setProductName(product.getProductName());
                    orderDetail.setProductPrice(product.getProductPrice());
                    orderDetail = orderDetailJpa.save(orderDetail);
                    newOrderDetailList1.add(orderDetail);
                }
            }

        }
        //扣库存
        List<CartDTO> cartDTOList = orderDetailList.stream().map(i -> new CartDTO(i.getProductId(),i.getProductQuantity()) ).collect(Collectors.toList());
        ResultVO resultVO = productFeignClient.decreaseStock(cartDTOList);
        if (resultVO.getCode() != 0) throw new OrderException("扣库存失败",0001);
        //订单入库
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setOrderId(orderId);
        orderInfo.setBuyerName(orderDTO.getBuyerName());
        orderInfo.setBuyerAddress(orderDTO.getBuyerAddress());
        orderInfo.setBuyerPhone(orderDTO.getBuyerPhone());
        orderInfo.setOrderAmount(totalMoney);
        orderInfo.setBuyerOpenid(orderDTO.getBuyerOpenid());
        orderInfo.setOrderStatus(0);
        orderInfo.setPayStatus(0);
        orderJpa.save(orderInfo);
        orderDTO.setOrderId(orderId);
        orderDTO.setOrderStatus(orderInfo.getOrderStatus());
        orderDTO.setPayStatus(orderInfo.getPayStatus());
        orderDTO.setOrderAmount(totalMoney);
        orderDTO.setOrderDetails(newOrderDetailList1);
        return orderDTO;
    }
}
