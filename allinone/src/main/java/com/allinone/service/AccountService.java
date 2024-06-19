package com.allinone.service;

import com.allinone.entity.Account;
import com.allinone.payload.AccountDto;

import java.util.List;

public interface AccountService {

    AccountDto createNewAccount(AccountDto accountDto);

    List<AccountDto> getAllAccounts();
}
