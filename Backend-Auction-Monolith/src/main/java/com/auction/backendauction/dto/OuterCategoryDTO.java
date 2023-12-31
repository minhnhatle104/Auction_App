package com.auction.backendauction.dto;

import com.auction.backendauction.entity.OuterCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OuterCategoryDTO {

    private String id;
    private String name;
    private List<InnerCategoryDTO> innerCategories;

}
