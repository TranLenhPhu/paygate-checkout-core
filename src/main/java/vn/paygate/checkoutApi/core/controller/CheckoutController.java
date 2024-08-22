package vn.paygate.checkoutApi.core.controller;

import vn.paygate.checkoutApi.core.entity.ConfigMerchantFee;
import vn.paygate.checkoutApi.core.entity.ConfigPaymentMethodChannel;
import vn.paygate.checkoutApi.core.entity.Merchant;
import vn.paygate.checkoutApi.core.model.input.CheckoutDepositInput;
import vn.paygate.checkoutApi.core.model.input.CheckoutTransferInput;
import vn.paygate.checkoutApi.core.model.input.OrderInput;
import vn.paygate.checkoutApi.core.model.output.CheckoutDepositOutput;
import vn.paygate.checkoutApi.core.model.output.CheckoutTransferOutput;
import vn.paygate.checkoutApi.core.model.output.OrderOutput;
import vn.paygate.checkoutApi.core.repository.MerchantRepository;
import vn.paygate.checkoutApi.core.service.APIService;
import vn.paygate.checkoutApi.core.service.MerchantFeeService;
import vn.paygate.checkoutApi.core.service.MerchantService;
import vn.paygate.checkoutApi.core.service.OrderService;
import vn.paygate.checkoutApi.core.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
//import vn.paygate.lib.encryption.MerchantEncryption;

import java.util.List;


@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private APIService apiService;

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private OrderService orderService;


    @Autowired
    private MerchantFeeService merchantFeeService;

    @GetMapping
    public List<Merchant> getAllMerchants(){
        return merchantService.getAllMerchants();
    }


    @GetMapping("/{merchantId}/config-payment-method-channels")
    public List<ConfigPaymentMethodChannel> getFilterredConfigPaymentMethodChannelsByMerchanId(@PathVariable String merchantId){
        return merchantService.getFilteredConfigPaymentMethodChannelsByMerchantId(merchantId);
    }

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order savedOrder = orderService.saveOrder(order);
        return ResponseEntity.ok(savedOrder);
    }

    @GetMapping("/merchants/{integrationMerchantCode}")
    public ResponseEntity<Merchant> getMerchant(@PathVariable String integrationMerchantCode){
        Merchant merchant = merchantService.findMerchantByIntegrationSecureCode(integrationMerchantCode);
        return ResponseEntity.ok(merchant);
    }
    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/merchantFee")
    public ResponseEntity<List<ConfigMerchantFee>> getAllMerchantFee(){
        List<ConfigMerchantFee> merchantFees = merchantFeeService.getAllMerchantFee();
        return ResponseEntity.ok(merchantFees);
    }

    @GetMapping("/order/{orderCode}")
    public ResponseEntity<Order> getOrderDetailsByOrderCode(@PathVariable String orderCode) {
        Order order = orderService.findOrderDetailsByOrderCode(orderCode);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/merchantFee/{merchantId}")
    public ResponseEntity<ConfigMerchantFee> getFeesByMerchantId(@PathVariable String merchantId) {
        ConfigMerchantFee fees = orderService.getFeesByMerchantId(merchantId);
        return ResponseEntity.ok(fees);
    }

}
