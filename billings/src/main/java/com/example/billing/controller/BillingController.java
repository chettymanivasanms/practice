package com.example.billing.controller;

import com.example.billing.model.Billing;
import com.example.billing.service.BillingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

    @Autowired
    private BillingService billingService;

    // Get all billings
    @GetMapping
    public List<Billing> getAllBillings() {
        return billingService.getAllBillings();
    }

    // Get billing by ID
    @GetMapping("/{id}")
    public ResponseEntity<Billing> getBillingById(@PathVariable Long id) {
        Optional<Billing> billing = billingService.getBillingById(id);
        return billing.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new billing
    @PostMapping
    public ResponseEntity<Billing> createBilling(@RequestBody Billing billing) {
        Billing createdBilling = billingService.createBilling(billing);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBilling);
    }

    // Update an existing billing
    @PutMapping("/{id}")
    public ResponseEntity<Billing> updateBilling(@PathVariable Long id, @RequestBody Billing billingDetails) {
        Billing updatedBilling = billingService.updateBilling(id, billingDetails);
        return updatedBilling != null ? ResponseEntity.ok(updatedBilling) : ResponseEntity.notFound().build();
    }

    // Delete a billing by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBilling(@PathVariable Long id) {
        billingService.deleteBilling(id);
        return ResponseEntity.noContent().build();
    }

    // Get billings by patient name
    @GetMapping("/patient/{patientName}")
    public List<Billing> getBillingsByPatientName(@PathVariable String patientName) {
        return billingService.getBillingsByPatientName(patientName);
    }

    // Get billings by payment status
    @GetMapping("/status/{status}")
    public List<Billing> getBillingsByPaymentStatus(@PathVariable Billing.PaymentStatus status) {
        return billingService.getBillingsByPaymentStatus(status);
    }
}
