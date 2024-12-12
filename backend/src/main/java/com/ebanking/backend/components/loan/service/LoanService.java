package com.ebanking.backend.components.loan.service;

import com.ebanking.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.ebanking.backend.components.loan.dto.request.CreateLoanDTO;
import com.ebanking.backend.components.loan.dto.request.UpdateLoanDTO;
import com.ebanking.backend.components.loan.dto.response.LoanResponseDTO;
import com.ebanking.backend.components.loan.mapper.LoanMapper;
import com.ebanking.backend.components.loan.repository.LoanRepository;
import com.ebanking.backend.entities.Loan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class LoanService extends EntityServiceImpl<Loan, Long, CreateLoanDTO, UpdateLoanDTO, LoanResponseDTO> {
    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;

    public LoanService(
            LoanRepository loanRepository,
            LoanMapper loanMapper,
            ApplicationContext applicationContext) {
        super(loanRepository, loanMapper, applicationContext);
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }
}
