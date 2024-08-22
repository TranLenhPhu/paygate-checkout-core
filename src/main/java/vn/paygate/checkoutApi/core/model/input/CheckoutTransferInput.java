package vn.paygate.checkoutApi.core.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CheckoutTransferInput {

    @NotNull(message = "sender is required")
    Long sender;
    @NotNull(message = "merchant_id is required")
    Long merchant_id;
    @NotNull(message = "receiver is required")
    Long receiver;
    @NotNull(message = "amount is required")
    BigDecimal amount;
    String ver02_trans_id;
    String ver02_trans_performed_time;

}
