package com.auction.backendauction.mapper;

import com.auction.backendauction.dto.InnerCategoryDTO;
import com.auction.backendauction.entity.InnerCategory;
import com.auction.backendauction.entity.OuterCategory;
import org.springframework.stereotype.Component;

@Component
public class InnerCategoryMapper implements EntityMapper<InnerCategory,InnerCategoryDTO>{


    @Override
    public InnerCategory toEntity(InnerCategoryDTO innerCategoryDTO) {
        InnerCategory innerCategory = new InnerCategory();
        OuterCategory outerCategory = new OuterCategory();

        innerCategory.setId(innerCategoryDTO.getId());
        innerCategory.setName(innerCategoryDTO.getName());
        outerCategory.setId(innerCategoryDTO.getOuterCategoryId());
        innerCategory.setOuterCategory(outerCategory);

        return innerCategory;
    }

    @Override
    public InnerCategoryDTO toDTO(InnerCategory innerCategory) {
        InnerCategoryDTO innerCategoryDTO = new InnerCategoryDTO();

        innerCategoryDTO.setId(innerCategory.getId());
        innerCategoryDTO.setName(innerCategory.getName());
        innerCategoryDTO.setOuterCategoryId(innerCategory.getOuterCategory().getId());

        return innerCategoryDTO;
    }
}
