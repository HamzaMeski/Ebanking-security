package com.ebanking.backend.components.user.dto.response;

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
public class UserResponseDTO extends ResponseDTO<User, Long> {
    private Long id;

    private String userName;

    private String password;

    private String role;

}
