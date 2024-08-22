package vn.paygate.checkoutApi.core.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MerchantInput {

    @NotNull
    private String userId;
    private String phone;
    private String address;
    private String merchantName;
    private String merchantType;
    private String merchantTags;
    private String checkoutDisplayName;
    private String checkoutDisplayAddress;
    private String checkoutDisplayPhone;
    private String checkoutDisplayLogoUrl;
    private String integrationNotifyUrl;

}
