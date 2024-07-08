package com.allinone.service;

import com.allinone.exception.AccountNotFoundException;
import com.allinone.payload.AccountConfirmationDto;
import com.allinone.payload.AccountDto;

import java.util.List;

public interface AccountService {

    AccountConfirmationDto createNewAccount(AccountDto accountDto);

    List<AccountDto> getAllAccounts();

    AccountDto getAccountById(long id) throws AccountNotFoundException;
}
