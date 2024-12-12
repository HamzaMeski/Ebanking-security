package com.ebanking.backend.components.loan.mapper;

import com.ebanking.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.ebanking.backend.entities.Loan;
import com.ebanking.backend.components.loan.dto.request.CreateLoanDTO;
import com.ebanking.backend.components.loan.dto.request.UpdateLoanDTO;
import com.ebanking.backend.components.loan.dto.response.LoanResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.ebanking.backend.components.user.mapper.UserMapper;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface LoanMapper extends EntityMapper<Loan, Long,
    CreateLoanDTO, UpdateLoanDTO, LoanResponseDTO> {

    @Mapping(target = "user", ignore = true)
    Loan toEntity(CreateLoanDTO createDTO);

    @Mapping(target = "user", ignore = true)
    void updateEntity(UpdateLoanDTO updateDTO, @MappingTarget Loan entity);

    LoanResponseDTO toResponseDTO(Loan entity);
}
