package ppc.order.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ppc.order.dto.OrderDTO;
import ppc.order.entity.OrderDetail;
import ppc.order.exception.OrderException;
import ppc.order.service.OrderService;
import ppc.order.vo.ResultVO;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public OrderDTO createOrder(@Valid OrderDTO orderDTO ){

//        OrderDTO orderDTO = new OrderDTO();
//        orderDTO.setBuyerName("ppc");
//        orderDTO.setBuyerPhone("18550124545");
//        orderDTO.setBuyerAddress("虹盛小区");
//        orderDTO.setBuyerOpenid("df454as5d14a5sd1asd");
//        orderDTO.setOrderDetails(new ArrayList<OrderDetail>(){{
//            add(new OrderDetail("157875227953464068",10));
//            add(new OrderDetail("157875196366160022",10));
//        }});
        Gson gson = new Gson();
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderDTO.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {

        }
        orderDTO.setOrderDetails(orderDetailList);
        return orderService.createOrder(orderDTO);
    }

}
