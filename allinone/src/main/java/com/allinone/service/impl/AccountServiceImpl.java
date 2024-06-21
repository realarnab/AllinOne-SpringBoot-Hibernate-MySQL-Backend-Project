package com.allinone.service.impl;

import com.allinone.entity.Account;
import com.allinone.payload.AccountConfirmationDto;
import com.allinone.payload.AccountDto;
import com.allinone.repository.AccountRepository;
import com.allinone.service.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public AccountConfirmationDto createNewAccount(AccountDto accountDto) {
        Account account = mapToEntity(accountDto);
        Account saved = accountRepository.save(account);
        return mapToDto(saved);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> all = accountRepository.findAll();
        return all.stream().map((element) -> modelMapper.map(element, AccountDto.class)).collect(Collectors.toList());
    }

    public AccountConfirmationDto mapToDto(Account account){
       return modelMapper.map(account,AccountConfirmationDto.class);
    }

    public Account mapToEntity(AccountDto dto){
        return modelMapper.map(dto,Account.class);
    }
}
