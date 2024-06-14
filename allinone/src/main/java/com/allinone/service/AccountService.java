package com.allinone.service;

import com.allinone.entity.Account;
import com.allinone.payload.AccountDto;

public interface AccountService {

    AccountDto createNewAccount(AccountDto accountDto);
}
