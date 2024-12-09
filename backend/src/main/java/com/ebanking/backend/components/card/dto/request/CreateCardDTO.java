package com.ebanking.backend.components.card.dto.request;

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
public class CreateCardDTO extends CreateDTO<Card> {

@RelationshipField(
        entity = User.class,
        repository = "com.ebanking.backend.components.user.repository.UserRepository"
)
@NotNull(message = "user is required")
private Long userId;

    private String cardNumber;

    private String cardType = "Credit";

    private LocalDate expiryDate = LocalDate.of(2025, 11, 1);

}