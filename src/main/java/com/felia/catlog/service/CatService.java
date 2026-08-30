package com.felia.catlog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.felia.catlog.domain.Cat;
import com.felia.catlog.dto.member.CatListItemResponse;
import com.felia.catlog.repository.CatRepository;

import jakarta.transaction.Transactional;

@Service
public class CatService {
  private final CatRepository catRepository;

  public CatService(CatRepository catRepository) {
    this.catRepository = catRepository;
  }

  @Transactional
  public List<Cat> getCats() {
    return catRepository.findAll();
  }

  @Transactional
  public List<CatListItemResponse> findRecontCat() {
    return catRepository.findTop7ByOrderByCreatedAtDesc().stream()
        .map(cat -> new CatListItemResponse(
            cat.getCatId(),
            cat.getBreedId(),
            cat.getName(),
            cat.getAgeMonth(),
            cat.getImageUrl()))
        .toList();
  }

}
