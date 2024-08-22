package vn.paygate.checkoutApi.core.service;

import vn.paygate.checkoutApi.core.entity.ConfigMerchantFee;
import vn.paygate.checkoutApi.core.model.input.OrderInput;
import vn.paygate.checkoutApi.core.repository.*;
import vn.paygate.checkoutApi.core.repository.OrderRepository;
//import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.paygate.checkoutApi.core.entity.Order;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MerchantFeeRepository merchantFeeRepository;

//    public Order findOrderCode(Long orderCode) {
//        return  orderRepository.findByOrderCode(orderCode);
//    }

    public Order saveOrder(Order order) {
        if (order.getCheckOutUrl() == null || order.getCheckOutUrl().isEmpty()) {
            order.setCheckOutUrl("http://paygate-v3-sandbox-checkout-web.nganluong.vn/web/index/{orderCode}");
        }
        Order savedOrder = orderRepository.save(order);
        String updatedCheckOutUrl = savedOrder.getCheckOutUrl().replace("{orderCode}", savedOrder.getOrderCode());
        savedOrder.setCheckOutUrl(updatedCheckOutUrl);
        return orderRepository.save(savedOrder);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderDetailsByOrderCode(String orderCode) {
        return orderRepository.findByOrderCode(orderCode);
    }

    public ConfigMerchantFee getFeesByMerchantId(String merchantId) {
        return merchantFeeRepository.findByMerchantId(merchantId);
    }
}
