package com.example.crud.domain.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record RequestClients(
        String id,
        @NotEmpty
        String name,

        @NotBlank
        String email,
        String cpf
) {
}
