package com.ebanking.backend.components.notice.dto.request;

import com.ebanking.backend.EntityComponentsProvider.dto.request.CreateDTO;
import com.ebanking.backend.EntityComponentsProvider.dto.request.RelationshipField;
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
public class CreateNoticeDTO extends CreateDTO<Notice> {
    @NotBlank(message = "title is required!")
    private String title;

    @NotBlank(message = "description is required!")
    private String description;

    @NotBlank(message = "createDate is required!")
    private LocalDateTime createdDate;

}
