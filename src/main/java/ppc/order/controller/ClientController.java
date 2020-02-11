package ppc.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ppc.order.client.ProductFeignClient;
import ppc.order.entity.Product;
import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ProductFeignClient productFeignClient;

    @GetMapping("/listForOrder")
    public List<Product> listForOrder(){
        return productFeignClient.findByProductIds(Arrays.asList("157875196366160022","157875227953464068"));
    }
}
