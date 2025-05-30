package com.teleport.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
    @NotBlank String username,
    @NotBlank @Email String email
) {}
