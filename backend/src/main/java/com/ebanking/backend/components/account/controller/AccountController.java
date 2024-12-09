package com.ebanking.backend.components.account.controller;

import com.ebanking.backend.EntityComponentsProvider.controller.Controller;
import com.ebanking.backend.components.account.dto.request.CreateAccountDTO;
import com.ebanking.backend.components.account.dto.request.UpdateAccountDTO;
import com.ebanking.backend.components.account.dto.response.AccountResponseDTO;
import com.ebanking.backend.components.account.service.AccountService;
import com.ebanking.backend.entities.Account;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController extends Controller<Account, Long, CreateAccountDTO, UpdateAccountDTO, AccountResponseDTO> {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        super(accountService);
        this.accountService = accountService;
    }
}
