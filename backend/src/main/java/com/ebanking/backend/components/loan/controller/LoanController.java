package com.ebanking.backend.components.loan.controller;

import com.ebanking.backend.EntityComponentsProvider.controller.Controller;
import com.ebanking.backend.components.loan.dto.request.CreateLoanDTO;
import com.ebanking.backend.components.loan.dto.request.UpdateLoanDTO;
import com.ebanking.backend.components.loan.dto.response.LoanResponseDTO;
import com.ebanking.backend.components.loan.service.LoanService;
import com.ebanking.backend.entities.Loan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/loans")
public class LoanController extends Controller<Loan, Long, CreateLoanDTO, UpdateLoanDTO, LoanResponseDTO> {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        super(loanService);
        this.loanService = loanService;
    }
}
