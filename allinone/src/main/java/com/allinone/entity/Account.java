package com.allinone.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "account_number",nullable = false,unique = true)
    private String accountNumber;
    private Double balance;

    @PrePersist
    public void prePersist() {
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber() {
        String prefix = "ACC";
        String suffix = String.format("%09d", (int)(Math.random() * 1000000000));
        return prefix + suffix;
    }
}
