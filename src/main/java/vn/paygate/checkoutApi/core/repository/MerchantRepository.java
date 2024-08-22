package vn.paygate.checkoutApi.core.repository;

import org.springframework.data.jpa.repository.Query;
import vn.paygate.checkoutApi.core.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    Merchant findMerchantByUserId(String id);

    Merchant findByIntegrationMerchantCode(String integrationMerchantCode);

    @Query("SELECT m FROM Merchant m WHERE m.id >= ?1 AND m.id <= ?2")
    List<Merchant> findByIdFirstAndIdLast(Long idFirst, Long idLast);
}
