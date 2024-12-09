package com.ebanking.backend.components.account.dto.request;

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
public class CreateAccountDTO extends CreateDTO<Account> {

@RelationshipField(
        entity = User.class,
        repository = "com.ebanking.backend.components.user.repository.UserRepository"
)
@NotNull(message = "user is required")
private Long userId;

    @NotBlank(message = "cardNumber is required!")
    private String accountNumber;

    private Double balance;

}
