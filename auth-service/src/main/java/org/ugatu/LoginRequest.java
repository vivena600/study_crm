package org.ugatu;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private String username; // = UUID студента или преподавателя, или "manager"
    @NotBlank
    private String password;
}
