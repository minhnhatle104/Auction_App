package com.auction.backendauction.mapper;
import com.auction.backendauction.dto.OuterCategoryDTO;
import com.auction.backendauction.entity.OuterCategory;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OuterCategoryMapper implements EntityMapper<OuterCategory, OuterCategoryDTO>{

    @Override
    public OuterCategory toEntity(OuterCategoryDTO outerCategoryDTO) {
        OuterCategory outerCategory = new OuterCategory();
        outerCategory.setId(outerCategoryDTO.getId());
        outerCategory.setName(outerCategoryDTO.getName());

        return outerCategory;
    }

    @Override
    public OuterCategoryDTO toDTO(OuterCategory outerCategory) {
        OuterCategoryDTO outerCategoryDTO = new OuterCategoryDTO();
        InnerCategoryMapper innerCategoryMapper = new InnerCategoryMapper();

        outerCategoryDTO.setId(outerCategory.getId());
        outerCategoryDTO.setName(outerCategory.getName());
        outerCategoryDTO.setInnerCategories(
                outerCategory
                        .getInnerCategories()
                        .stream()
                        .map(innerCategoryMapper::toDTO)
                        .collect(Collectors.toList())
        );

        return outerCategoryDTO;
    }
}
