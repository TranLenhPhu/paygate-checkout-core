package vn.paygate.checkoutApi.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private Long sender;
    private Long receiver;
    private Long orderId;
    private String CashinId;
    private Long type;
    private String paymemtMethodCode;
    private String paymentMethodBankCode;
    private Long configMerchantFeeId;
    private String status;
    private Date createTime;
    private Date settleTime;

}
