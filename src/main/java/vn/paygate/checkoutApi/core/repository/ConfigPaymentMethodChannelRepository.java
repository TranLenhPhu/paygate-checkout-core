package vn.paygate.checkoutApi.core.repository;

import vn.paygate.checkoutApi.core.entity.ConfigPaymentMethodChannel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfigPaymentMethodChannelRepository extends JpaRepository<ConfigPaymentMethodChannel,Long> {
    List<ConfigPaymentMethodChannel> findByMerchantId(String merchantId);

}
