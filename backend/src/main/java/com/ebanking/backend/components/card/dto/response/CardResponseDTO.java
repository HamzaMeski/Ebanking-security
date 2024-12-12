package com.ebanking.backend.components.card.dto.response;

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
public class CardResponseDTO extends ResponseDTO<Card, Long> {

private UserResponseDTO user;

    private Long id;

    private String cardNumber;

    private String cardType;

    private LocalDate expiryDate;

}
