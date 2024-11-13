package com.example.billing.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private Double amount;
    private Date dateOfBilling;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    // Constructors, Getters, and Setters
    public Billing() {}

    public Billing(String patientName, Double amount, Date dateOfBilling, PaymentStatus paymentStatus) {
        this.patientName = patientName;
        this.amount = amount;
        this.dateOfBilling = dateOfBilling;
        this.paymentStatus = paymentStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDateOfBilling() {
        return dateOfBilling;
    }

    public void setDateOfBilling(Date dateOfBilling) {
        this.dateOfBilling = dateOfBilling;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    // Enum for payment status
    public enum PaymentStatus {
        PENDING, PAID, OVERDUE
    }
}
