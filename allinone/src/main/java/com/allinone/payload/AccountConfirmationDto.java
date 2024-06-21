package com.allinone.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountConfirmationDto {
    private String accountNumber;
    private Double balance;
    private String type;
}
