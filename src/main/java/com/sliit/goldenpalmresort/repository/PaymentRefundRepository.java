package com.sliit.goldenpalmresort.repository;

import com.sliit.goldenpalmresort.model.PaymentRefund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface PaymentRefundRepository extends JpaRepository<PaymentRefund, Long> {

	List<PaymentRefund> findByPaymentIdOrderByRefundDateDesc(Long paymentId);

	@Query("SELECT COALESCE(SUM(r.amount), 0) FROM PaymentRefund r WHERE r.payment.id = :paymentId")
	BigDecimal sumRefundsByPaymentId(@Param("paymentId") Long paymentId);
}


