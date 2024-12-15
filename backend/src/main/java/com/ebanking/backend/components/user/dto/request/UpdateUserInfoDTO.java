package com.ebanking.backend.components.user.dto.request;

import com.ebanking.backend.EntityComponentsProvider.dto.request.UpdateDTO;
import com.ebanking.backend.entities.*;
import jakarta.validation.constraints.*;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdateUserInfoDTO extends UpdateDTO<User> {
    @NotBlank(message = "firstName is required!")
    private String firstName;

    @NotBlank(message = "lastName is required!")
    private String lastName;

    @NotBlank(message = "email is required!")
    @Email(message = "email you did set is not valid")
    private String email;

    @NotBlank(message = "password is required!")
    private String password;
}
