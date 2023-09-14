package com.auction.backendauction.service;

import com.auction.backendauction.dto.InnerCategoryDTO;
import com.auction.backendauction.entity.InnerCategory;

import java.util.List;

public interface InnerCategoryService {

    InnerCategoryDTO createInnerCategory(InnerCategoryDTO innerCategory);

   List<InnerCategoryDTO> getListCategory();

    InnerCategoryDTO getCategoryById(String id);

    InnerCategoryDTO updateCategory(InnerCategoryDTO innerCategory);

    void deleteInnerCategory(String id);
}
