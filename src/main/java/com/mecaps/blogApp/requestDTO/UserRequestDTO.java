package com.mecaps.blogApp.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDTO {
  @NotBlank(message = "User name is Required")
  @Size(min  = 3 , max = 10 , message =  "The User name  is should be in 3-10 characters")
    private String userName;
    private String password;
    @Email
    private String email;

}
