package ppc.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import ppc.order.dto.CartDTO;
import ppc.order.entity.Product;
import ppc.order.vo.ResultVO;

import java.util.List;

@FeignClient("product")
public interface ProductFeignClient {

    @GetMapping("/findAll")
    public String getAllProduct();

    @GetMapping("/listForOrder")
    public List<Product> findByProductIds(List<String> productIds);

    @GetMapping("/decreaseStock")
    public ResultVO decreaseStock(List<CartDTO> cartDTOS);
}
