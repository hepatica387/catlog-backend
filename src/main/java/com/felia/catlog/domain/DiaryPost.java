package com.felia.catlog.domain;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "diary_posts")
@Getter
@NoArgsConstructor
public class DiaryPost {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "post_id")
  private Long postId;

  @Column(name = "user_id", length = 50, nullable = false)
  private String userId;

  @Column(name = "title", length = 200, nullable = false)
  private String title;

  @Column(name = "content", columnDefinition = "TEXT")
  private String content;

  @Column(name = "category", length = 30, nullable = false)
  private String category;

  @Column(name = "thumbnail_img", length = 255, nullable = false)
  private String thumbnailUrl;

  @Column(name = "view_count", nullable = false)
  private Integer viewCount;

  @Column(name = "like_count", nullable = false)
  private Integer likeCount;

  @Column(name = "commnet_count", nullable = false)
  private Integer commentCount;

  @Column(name = "is_public", nullable = false, columnDefinition = "TINYINT(1)")
  private Boolean isPublic;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;
}