package ppc.order.jpa;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ppc.order.entity.OrderInfo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class OrderJpaTest {

    @Autowired
    private OrderJpa jpa;

    @Test
    public void findAll(){
        List<OrderInfo> orderInfos = jpa.findAll();
        System.out.println(orderInfos);
    }




}