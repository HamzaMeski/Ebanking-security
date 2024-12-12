package com.ebanking.backend.components.notice.dto.response;

import com.ebanking.backend.EntityComponentsProvider.dto.response.ResponseDTO;
import com.ebanking.backend.entities.*;
import java.time.*;
import java.util.*;
import java.math.*;
import jakarta.validation.constraints.*;


import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NoticeResponseDTO extends ResponseDTO<Notice, Long> {
    private Long id;

    private String title;

    private String description;

    private LocalDateTime createdDate;

}
