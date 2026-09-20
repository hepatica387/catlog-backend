package com.felia.catlog.dto.member;

import java.time.LocalDateTime;

public record DiaryPostResponse(
  Long postId,
  String title,
  String thumbnailUrl,
  String authorName,
  LocalDateTime created_at,
  Integer likeCount,
  Integer viewCount
) {
}
