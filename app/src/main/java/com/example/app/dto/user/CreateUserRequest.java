package com.example.app.dto.user;

import jakarta.validation.constraints.*;

public class CreateUserRequest {
    @NotBlank
    @Size(min=3, max=30)
    public String username;

    @NotBlank
    @Size(min=8, max=24)
    public String password;

    @NotBlank
    @Size(min=11, max=11)
    public String cellphone;

    @NotBlank
    @Size(min=6, max=50)
    public String email;
}
