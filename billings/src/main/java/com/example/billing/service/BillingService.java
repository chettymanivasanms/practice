package com.example.billing.service;

import com.example.billing.model.Billing;
import com.example.billing.repository.BillingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    @Autowired
    private BillingRepository billingRepository;

    public Billing createBilling(Billing billing) {
        return billingRepository.save(billing);
    }

    public List<Billing> getAllBillings() {
        return billingRepository.findAll();
    }

    public Optional<Billing> getBillingById(Long id) {
        return billingRepository.findById(id);
    }

    public List<Billing> getBillingsByPatientName(String patientName) {
        return billingRepository.findByPatientName(patientName);
    }

    public List<Billing> getBillingsByPaymentStatus(Billing.PaymentStatus status) {
        return billingRepository.findByPaymentStatus(status);
    }

    public Billing updateBilling(Long id, Billing billingDetails) {
        Optional<Billing> existingBilling = billingRepository.findById(id);
        if (existingBilling.isPresent()) {
            Billing billing = existingBilling.get();
            billing.setPatientName(billingDetails.getPatientName());
            billing.setAmount(billingDetails.getAmount());
            billing.setDateOfBilling(billingDetails.getDateOfBilling());
            billing.setPaymentStatus(billingDetails.getPaymentStatus());
            return billingRepository.save(billing);
        }
        return null;
    }

    public void deleteBilling(Long id) {
        billingRepository.deleteById(id);
    }
}
