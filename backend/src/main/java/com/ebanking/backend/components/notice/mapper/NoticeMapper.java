package com.ebanking.backend.components.notice.mapper;

import com.ebanking.backend.EntityComponentsProvider.mapper.EntityMapper;
import com.ebanking.backend.entities.Notice;
import com.ebanking.backend.components.notice.dto.request.CreateNoticeDTO;
import com.ebanking.backend.components.notice.dto.request.UpdateNoticeDTO;
import com.ebanking.backend.components.notice.dto.response.NoticeResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface NoticeMapper extends EntityMapper<Notice, Long,
    CreateNoticeDTO, UpdateNoticeDTO, NoticeResponseDTO> {

    
    Notice toEntity(CreateNoticeDTO createDTO);

    
    void updateEntity(UpdateNoticeDTO updateDTO, @MappingTarget Notice entity);

    NoticeResponseDTO toResponseDTO(Notice entity);
}
