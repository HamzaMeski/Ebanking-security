package com.ebanking.backend.components.card.mapper;

import com.ebanking.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.ebanking.backend.entities.Card;
import com.ebanking.backend.components.card.dto.request.CreateCardDTO;
import com.ebanking.backend.components.card.dto.request.UpdateCardDTO;
import com.ebanking.backend.components.card.dto.response.CardResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import com.ebanking.backend.components.user.mapper.UserMapper;

@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface CardMapper extends EntityMapper<Card, Long,
    CreateCardDTO, UpdateCardDTO, CardResponseDTO> {

    @Mapping(target = "user", ignore = true)
    Card toEntity(CreateCardDTO createDTO);

    @Mapping(target = "user", ignore = true)
    void updateEntity(UpdateCardDTO updateDTO, @MappingTarget Card entity);

    CardResponseDTO toResponseDTO(Card entity);
}
