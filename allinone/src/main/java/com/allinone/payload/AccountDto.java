package com.allinone.payload;

import com.allinone.entity.User;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private String accountNumber;
    private Double balance;
    private String type;
    private User user;
}
