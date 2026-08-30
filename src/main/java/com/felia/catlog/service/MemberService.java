package com.felia.catlog.service;

import com.felia.catlog.domain.Member;
import com.felia.catlog.dto.member.LoginRequest;
import com.felia.catlog.dto.member.LoginResponse;
import com.felia.catlog.dto.member.SignupRequest;
import com.felia.catlog.exception.DuplicateMemberException;
import com.felia.catlog.repository.MemberRepository;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;

  public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
    this.memberRepository = memberRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Transactional
  public void signup(SignupRequest request) {
    Member member = new Member();

    if (memberRepository.existsByUserId(request.getUserId())) {
      throw new DuplicateMemberException("이미 사용 중인 아이디입니다.");
    }
    if (memberRepository.existsByEmail(request.getEmail())) {
      throw new DuplicateMemberException("이미 사용 중인 이메일입니다.");
    }

    member.setUserId(request.getUserId());
    member.setUserPw(passwordEncoder.encode(request.getUserPw()));
    member.setEmail(request.getEmail());
    member.setUserName(request.getUserName());
    member.setPhone(request.getPhone());
    member.setBirthDay(request.getBirthDay());

    memberRepository.save(member);
  }

  public LoginResponse login(LoginRequest request) {

    Member member = memberRepository.findById(request.getUserId())
        .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀버놓가 올바르지 않습니다"));

    boolean passwordMatches = passwordEncoder.matches(request.getUserPw(), member.getUserPw());

    if (!passwordMatches) {
      throw new IllegalArgumentException("아이디 또는 비밀번호가 올바르지 않습니다");
    }

    return new LoginResponse(
        member.getUserId(),
        member.getUserName(),
        member.getEmail());

  }
}
