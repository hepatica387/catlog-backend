package com.felia.catlog.domain;

import java.time.LocalDateTime;

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
@Table(name = "cats")
@Getter
@Setter
@NoArgsConstructor
public class Cat {

  @Id
  @Column(name = "cat_id", length = 50, nullable = false)
  private String catId;

  @Column(name = "breed_id", nullable = false)
  private Integer breedId;

  @Column(name = "name", length = 15, nullable = false)
  private String name;

  @Column(name = "gender", length = 1, nullable = false)
  private Character gender;

  @Column(name = "age_month", nullable = false, columnDefinition = "TINYINT")
  private Integer ageMonth;

  @Column(name = "color", length = 30, nullable = false)
  private String color;

  @Column(name = "weight", nullable = false, columnDefinition = "SMALLINT")
  private Short weight;

  @Column(name = "personality", nullable = false, columnDefinition = "TEXT")
  private String personality;

  @Column(name = "health_status", columnDefinition = "TEXT")
  private String healthStatus;

  @Column(name = "adoption_status", length = 1, nullable = false)
  private Character adoptionStatus;

  @Column(name = "main_img_url", length = 255)
  private String imageUrl;

  @Column(name = "created_at", nullable = false, updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @PrePersist
  private void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  private void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
