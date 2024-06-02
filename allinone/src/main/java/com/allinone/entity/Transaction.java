package com.allinone.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "reference_no",unique = true,nullable = false)
    private String referenceNo;
    @Column(name = "transaction_type",unique = true)
    private String transactionType;

    private Double amount;

    private LocalDateTime transactionDate;

    @PrePersist
    public void prePersist() {
        this.transactionDate = LocalDateTime.now();
    }
}
