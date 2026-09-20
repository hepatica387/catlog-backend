package com.felia.catlog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felia.catlog.domain.Member;
import com.felia.catlog.dto.member.LoginRequest;
import com.felia.catlog.dto.member.LoginResponse;
import com.felia.catlog.dto.member.MemberInfoResponse;
import com.felia.catlog.dto.member.SignupRequest;
import com.felia.catlog.service.MemberService;

import jakarta.validation.Valid;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/api/members")
public class MemberController {
  private final MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @PostMapping
  public ResponseEntity<Void> signup(@Valid @RequestBody SignupRequest request) {
    memberService.signup(request);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
    LoginResponse response = memberService.login(request);
    return ResponseEntity.ok(response);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<MemberInfoResponse> getUserInfo(@PathVariable String userId) {
    MemberInfoResponse userInfo = memberService.getFindByUserId(userId);

    return ResponseEntity.ok(userInfo);
  }
}
