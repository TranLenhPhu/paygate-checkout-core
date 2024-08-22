package vn.paygate.checkoutApi.core.repository;

import org.springframework.data.jpa.repository.Query;
import vn.paygate.checkoutApi.core.entity.ConfigMerchantFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfigMerchantFeeRepository extends JpaRepository<ConfigMerchantFee,Long> {
    List<ConfigMerchantFee> findByMerchantId(String merchantId);

    @Query("SELECT c FROM ConfigMerchantFee c WHERE c.id >= ?1 AND c.id <= ?2")
    List<ConfigMerchantFee> findByIdFirstAndIdLast(Long idFirst, Long idLast);
}
