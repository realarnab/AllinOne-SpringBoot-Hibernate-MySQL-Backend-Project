package com.allinone.controller;

import com.allinone.payload.AccountConfirmationDto;
import com.allinone.payload.AccountDto;
import com.allinone.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/new")
    public ResponseEntity<AccountConfirmationDto> createAccount(@RequestBody AccountDto accountDto){
        AccountConfirmationDto newAccount = accountService.createNewAccount(accountDto);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AccountDto>> getAll(){
        List<AccountDto> allAccounts = accountService.getAllAccounts();
        return new ResponseEntity<>(allAccounts,HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable long id){
        AccountDto accountById = accountService.getAccountById(id);
        return new ResponseEntity<>(accountById,HttpStatus.OK);
    }
}
