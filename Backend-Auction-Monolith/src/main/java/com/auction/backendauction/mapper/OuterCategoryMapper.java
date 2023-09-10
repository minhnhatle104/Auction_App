package com.auction.backendauction.mapper;

import com.auction.backendauction.dto.OuterCategoryDTO;
import com.auction.backendauction.entity.OuterCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OuterCategoryMapper {

    OuterCategoryMapper MAPPER = Mappers.getMapper(OuterCategoryMapper.class);

    OuterCategoryDTO mapToDTO(OuterCategory outerCategory);

    OuterCategory mapToEntity(OuterCategoryDTO outerCategoryDTO);

}
