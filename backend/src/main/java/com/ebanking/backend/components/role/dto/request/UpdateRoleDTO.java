package com.ebanking.backend.components.role.dto.request;

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
public class UpdateRoleDTO extends UpdateDTO<Role> {
    @NotBlank(message = "name is required!")
    private String name;

}