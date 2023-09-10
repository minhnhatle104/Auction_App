package com.auction.backendauction.service;

import com.auction.backendauction.dto.OuterCategoryDTO;

import java.util.List;

public interface OuterCategoryService {

    OuterCategoryDTO createOuterCategory(OuterCategoryDTO outerCategory);

    OuterCategoryDTO getCategoryById(String id);

    List<OuterCategoryDTO> getCategories();

    OuterCategoryDTO updateCategory(OuterCategoryDTO category);

    void deleteOuterCategory(String id);

}
