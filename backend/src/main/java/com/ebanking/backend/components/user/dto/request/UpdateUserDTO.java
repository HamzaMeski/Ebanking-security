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
    @NotBlank(message = "firstName is required!")
    private String firstName;

    @NotBlank(message = "lastName is required!")
    private String lastName;

    @NotBlank(message = "email is required!")
    @Email(message = "email you did set is not valid")
    private String email;

    @NotBlank(message = "password is required!")
    private String password;

    @NotNull(message = "role is required!")
    private Role role;
}
