package com.dabodibo.capitalhub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAccountDto {

    private Long id;

    @NotEmpty(message = "Email is required!")
    @Email
    private String userEmail;

    @NotEmpty(message = "Password is required")
    private String userPassword;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
