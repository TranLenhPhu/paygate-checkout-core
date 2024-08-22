package vn.paygate.checkoutApi.core.repository;

import vn.paygate.checkoutApi.core.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}