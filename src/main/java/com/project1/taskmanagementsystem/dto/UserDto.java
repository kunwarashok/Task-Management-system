package com.project1.taskmanagementsystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    @NotBlank(message = "Username is required")
    private String username;
    @Email(message = "Username is required")
    private String email;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "First name is required")
    private String lastName;

}
