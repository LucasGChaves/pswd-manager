package com.example.app.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginUserRequest {

    @NotBlank
    @Size(min=6, max=50)
    public String email;

    @NotBlank
    @Size(min=8, max=24)
    public String password;
}
