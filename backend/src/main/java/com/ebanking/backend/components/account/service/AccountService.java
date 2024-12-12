package com.ebanking.backend.components.account.service;

import com.ebanking.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.ebanking.backend.components.account.dto.request.CreateAccountDTO;
import com.ebanking.backend.components.account.dto.request.UpdateAccountDTO;
import com.ebanking.backend.components.account.dto.response.AccountResponseDTO;
import com.ebanking.backend.components.account.mapper.AccountMapper;
import com.ebanking.backend.components.account.repository.AccountRepository;
import com.ebanking.backend.entities.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class AccountService extends EntityServiceImpl<Account, Long, CreateAccountDTO, UpdateAccountDTO, AccountResponseDTO> {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountService(
            AccountRepository accountRepository,
            AccountMapper accountMapper,
            ApplicationContext applicationContext) {
        super(accountRepository, accountMapper, applicationContext);
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }
}
