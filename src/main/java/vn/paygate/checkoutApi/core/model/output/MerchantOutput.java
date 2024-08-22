package vn.paygate.checkoutApi.core.model.output;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MerchantOutput {

    private Long id;
    private String userId;
    private String merchantName;
    private String phone;
    private String address;
    private String checkoutDisplayName;
    private String checkoutDisplayAddress;
    private String checkoutDisplayPhone;
    private String checkoutDisplayLogoUrl;
    private String merchantType;
    private String merchantTags;
    private String integrationMerchantCode;
    private String integrationNotifyUrl;
    private String integrationSecurePassMassedPan;

}
