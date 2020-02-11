package ppc.order.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ppc.order.entity.OrderDetail;

@Repository
public interface OrderDetailJpa extends JpaRepository<OrderDetail,String> {

}
