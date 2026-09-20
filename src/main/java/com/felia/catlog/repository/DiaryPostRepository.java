package com.felia.catlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felia.catlog.domain.DiaryPost;

public interface DiaryPostRepository
    extends JpaRepository<DiaryPost, Long> {

  List<DiaryPost> findByIsPublicTrueOrderByCreatedAtDescPostIdDesc();

  List<DiaryPost> findByUserIdOrderByCreatedAtDesc(String userId);
}