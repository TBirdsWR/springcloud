package ppc.order.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ppc.order.entity.OrderInfo;

@Repository
public interface OrderJpa extends JpaRepository<OrderInfo,String> {
}
