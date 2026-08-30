package com.felia.catlog.dto.member;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequest {
  @NotBlank
  private String userId;
  @NotBlank
  private String userPw;

}
