package ppc.order.dto;

import lombok.Data;
import ppc.order.entity.OrderDetail;

import javax.persistence.Id;
import java.util.List;

@Data
public class OrderDTO {

    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private double orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private List<OrderDetail> orderDetails;

    private String items;
}
