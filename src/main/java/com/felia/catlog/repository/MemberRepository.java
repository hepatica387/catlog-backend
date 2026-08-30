package com.felia.catlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felia.catlog.domain.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

  boolean existsByUserId(String userId);

  boolean existsByEmail(String email);
}
