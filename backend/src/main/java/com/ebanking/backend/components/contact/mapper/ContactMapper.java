package com.ebanking.backend.components.contact.mapper;

import com.ebanking.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.ebanking.backend.entities.Contact;
import com.ebanking.backend.components.contact.dto.request.CreateContactDTO;
import com.ebanking.backend.components.contact.dto.request.UpdateContactDTO;
import com.ebanking.backend.components.contact.dto.response.ContactResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.ebanking.backend.components.user.mapper.UserMapper;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface ContactMapper extends EntityMapper<Contact, Long,
    CreateContactDTO, UpdateContactDTO, ContactResponseDTO> {

    @Mapping(target = "user", ignore = true)
    Contact toEntity(CreateContactDTO createDTO);

    @Mapping(target = "user", ignore = true)
    void updateEntity(UpdateContactDTO updateDTO, @MappingTarget Contact entity);

    ContactResponseDTO toResponseDTO(Contact entity);
}
