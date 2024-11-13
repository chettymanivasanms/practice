package com.example.billing.repository;

import com.example.billing.model.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
    List<Billing> findByPatientName(String patientName);
    List<Billing> findByPaymentStatus(Billing.PaymentStatus paymentStatus);
}
