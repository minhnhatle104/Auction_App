package com.auction.backendauction.repository;

import com.auction.backendauction.entity.OuterCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OuterCategoryRepository extends JpaRepository<OuterCategory,String> {

    Optional<OuterCategory> findByName(String name);

}
