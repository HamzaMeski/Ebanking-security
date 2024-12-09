package com.ebanking.backend.components.loan.dto.response;

import com.ebanking.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.ebanking.backend.entities.*;
import java.time.*;
import java.util.*;
import java.math.*;
import jakarta.validation.constraints.*;

import com.ebanking.backend.components.user.dto.response.UserResponseDTO;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LoanResponseDTO extends ResponseDTO<Loan, Long> {

private UserResponseDTO user;

    private Long id;

    private String loanType;

    private Double amount;

    private Double remainingBalance;

}
