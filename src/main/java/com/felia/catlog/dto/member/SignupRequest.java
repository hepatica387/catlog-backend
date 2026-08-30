package com.felia.catlog.dto.member;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
  @NotBlank
  private String userId;
  @NotBlank
  private String userPw;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  private String userName;
  @NotBlank
  private String phone;
  @NotNull
  private LocalDate birthDay;
}
