package com.felia.catlog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felia.catlog.domain.Cat;

public interface CatRepository extends JpaRepository<Cat, String> {

  List<Cat> findTop7ByOrderByCreatedAtDesc();
}
