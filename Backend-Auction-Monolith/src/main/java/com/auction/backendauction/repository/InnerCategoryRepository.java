package com.auction.backendauction.repository;

import com.auction.backendauction.entity.InnerCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InnerCategoryRepository extends JpaRepository<InnerCategory,String> {

    Optional<InnerCategory> findByName(String name);

}
