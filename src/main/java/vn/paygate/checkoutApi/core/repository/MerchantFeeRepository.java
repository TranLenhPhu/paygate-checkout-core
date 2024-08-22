package vn.paygate.checkoutApi.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.paygate.checkoutApi.core.entity.ConfigMerchantFee;

import java.util.List;

public interface MerchantFeeRepository extends JpaRepository<ConfigMerchantFee,Long> {
    ConfigMerchantFee findByMerchantId(String merchantId);
}
