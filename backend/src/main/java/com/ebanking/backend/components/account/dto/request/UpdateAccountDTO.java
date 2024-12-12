package com.ebanking.backend.components.account.dto.request;

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
public class UpdateAccountDTO extends UpdateDTO<Account> {

@RelationshipField(
        entity = User.class,
        repository = "com.ebanking.backend.components.user.repository.UserRepository"
)
private Long userId;

    @NotBlank(message = "email is required!")
    private String email;

    @NotBlank(message = "phoneNumber is required!")
    private String phoneNumber;

    private String address;

    private Double balance;

}
