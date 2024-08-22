package vn.paygate.checkoutApi.core.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String merchantName;
    @Column(unique = true)
    private String userId;
    private String checkoutDisplayName;
    private String address;
    private String checkoutDisplayAddress;
    private String phone;
    private String checkoutDisplayPhone;
    private String checkoutDisplayLogoUrl;
    private String merchantType;
    private String merchantTags;
    private String integrationSecureCode;
    private String integrationMerchantCode;
    private String integrationNotifyUrl;
    private String integrationSecurePassMassedPan;

}
