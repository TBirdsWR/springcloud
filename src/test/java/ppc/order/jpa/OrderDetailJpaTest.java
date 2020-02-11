package ppc.order.jpa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ppc.order.entity.OrderDetail;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderDetailJpaTest {

    @Autowired
    private OrderDetailJpa jpa;

    @Test
    public void findAll(){
        List<OrderDetail> orderDetails = jpa.findAll();
        System.out.println(orderDetails);
    }

    @Test
    public void testSave(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("4154110");
        orderDetail.setOrderId("00002");
        orderDetail.setProductIcon("wwww.abnas.cscasc/");
        orderDetail.setProductId("157875227953464068");
        orderDetail.setProductName("鸡翅");
        orderDetail.setProductPrice(5.0);
        orderDetail.setProductQuantity(10);
//        orderDetail.setCreateTime(new Date());
//        orderDetail.setUpdateTime(new Date());
        jpa.save(orderDetail);
    }
}