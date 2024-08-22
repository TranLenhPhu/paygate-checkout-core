package vn.paygate.checkoutApi.core.model.input;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class CheckoutDepositInput {
    Long receiver;
    BigDecimal amount;
    Long merchant_id;
    String cashin_receipt;
    String ver02_cashin_id;
    Date ver02_cashin_performed_time;
}
