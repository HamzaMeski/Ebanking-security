package com.ebanking.backend.components.card.dto.request;

import com.ebanking.backend.EntityComponentsProvider.dto.request.UpdateDTO;
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
public class UpdateCardDTO extends UpdateDTO<Card> {

@RelationshipField(
        entity = User.class,
        repository = "com.ebanking.backend.components.user.repository.UserRepository"
)
private Long userId;

    private String cardNumber;

    private String cardType;

    @NotNull(message = "expiryDate is required!")
    private LocalDate expiryDate;

}
