package com.petOcare.security.dto;

import com.petOcare.security.validation.ValidEmail;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {
  @NotNull
  @Size(min = 1, message = "Please enter your FirstName")
  private String firstName;

  @NotNull
  @Size(min = 1, message = "Please enter your LastName")
  private String lastName;

  private String password;

  @ValidEmail
  @NotNull
  @Size(min = 1, message = "Enter valid emailID")
  private String email;

  private String roles;
  private Integer age;
}
