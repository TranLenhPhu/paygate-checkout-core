package vn.paygate.checkoutApi.core.repository;

import vn.paygate.checkoutApi.core.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order ,Long> {
    Order findByOrderCode(String orderCode);
//        Order findByOrderCode(Long orderCode);
//Merchant findMerchantById(Long id);

}
