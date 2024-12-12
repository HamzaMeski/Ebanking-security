package com.ebanking.backend.components.account.mapper;

import com.ebanking.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.ebanking.backend.entities.Account;
import com.ebanking.backend.components.account.dto.request.CreateAccountDTO;
import com.ebanking.backend.components.account.dto.request.UpdateAccountDTO;
import com.ebanking.backend.components.account.dto.response.AccountResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.ebanking.backend.components.user.mapper.UserMapper;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface AccountMapper extends EntityMapper<Account, Long,
    CreateAccountDTO, UpdateAccountDTO, AccountResponseDTO> {

    @Mapping(target = "user", ignore = true)
    Account toEntity(CreateAccountDTO createDTO);

    @Mapping(target = "user", ignore = true)
    void updateEntity(UpdateAccountDTO updateDTO, @MappingTarget Account entity);

    AccountResponseDTO toResponseDTO(Account entity);
}
