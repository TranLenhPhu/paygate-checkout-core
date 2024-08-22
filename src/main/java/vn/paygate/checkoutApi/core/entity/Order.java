package vn.paygate.checkoutApi.core.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String merchantId;
    private String userId;
    private String orderAmount;

    @Column(unique = true)
    private String orderCode;

    private String merchantCode;
    private String orderMerchantTime;
    private String orderPaymentMethodBankCode;
    private String orderPaymentMethodCode;
    private String successRedirectUrl;
    private String cancelRedirectUrl;
    private String successCallbackUrl;
    private String status;
    private String displayRequestFirstTime;
    private String orderCreateTime;
    private String customerIpFirstTime;
    private String displayRequestLastTime;
    private String selectedPaymentMethodCode;
    private String selectedPaymentMethodCodeTime;
    private String selectebPaymentMethodBankCode;
    private String selectebPaymentMethodBankCodeTime;
    private String selectebConfigMerchantFeeId;
    private String cashinId;
    private String transactionId;
    private String currency;
    private String checkOutUrl;
}
