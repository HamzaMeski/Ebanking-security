package com.ebanking.backend.components.user.dto.request;

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
public class UpdateUserDTO extends UpdateDTO<User> {
    @NotBlank(message = "userName is required!")
    private String userName;

    @NotBlank(message = "password is required!")
    private String password;

    @NotBlank(message = "role is required!")
    private String role;

}
