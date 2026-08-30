package com.felia.catlog.domain;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class Member {

  @Id
  @Column(name = "user_id", length = 50, nullable = false)
  private String userId;

  @Column(name = "email", length = 255, nullable = false, unique = true)
  private String email;

  @Column(name = "user_pw", length = 255, nullable = false)
  private String userPw;

  @Column(name = "user_name", length = 255, nullable = false)
  private String userName;

  @Column(name = "phone", length = 15, nullable = false)
  private String phone;

  @Column(name = "birth_day", nullable = false)
  private LocalDate birthDay;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDate createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDate updatedAt;

  @PrePersist
  private void onCreate() {
    LocalDate now = LocalDate.now();
    createdAt = now;
    updatedAt = now;
  }

  @PreUpdate
  private void onUpdate() {
    updatedAt = LocalDate.now();
  }
}
