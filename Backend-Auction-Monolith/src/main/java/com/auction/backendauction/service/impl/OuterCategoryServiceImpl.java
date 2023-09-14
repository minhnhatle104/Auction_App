package com.auction.backendauction.service.impl;

import com.auction.backendauction.dto.OuterCategoryDTO;
import com.auction.backendauction.entity.OuterCategory;
import com.auction.backendauction.exception.impl.OuterCategoryAlreadyExists;
import com.auction.backendauction.exception.impl.ResourceNotFoundException;
import com.auction.backendauction.mapper.OuterCategoryMapper;
import com.auction.backendauction.repository.OuterCategoryRepository;
import com.auction.backendauction.service.OuterCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OuterCategoryServiceImpl implements OuterCategoryService {

    @Autowired
    private OuterCategoryRepository categoryRepository;

    @Autowired
    private OuterCategoryMapper outerCategoryMapper;

    @Override
    public OuterCategoryDTO createOuterCategory(OuterCategoryDTO outerCategoryDTO) {
        Optional<OuterCategory> existedCategory = categoryRepository.findByName(outerCategoryDTO.getName());
        if (existedCategory.isPresent()) {
            throw new OuterCategoryAlreadyExists("Outer category already exists");
        }

        OuterCategory category = outerCategoryMapper.toEntity(outerCategoryDTO);
        OuterCategory savedCategory = categoryRepository.save(category);

        OuterCategoryDTO savedCategoryDTO = outerCategoryMapper.toDTO(savedCategory);

        return savedCategoryDTO;
    }

    @Override
    public OuterCategoryDTO getCategoryById(String id) {
        OuterCategory category = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Outer Category", "id", id)
        );
        return outerCategoryMapper.toDTO(category);
    }

    @Override
    public List<OuterCategoryDTO> getCategories() {
        List<OuterCategory> categories = categoryRepository.findAll();

        return categories.stream().map(outerCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OuterCategoryDTO updateCategory(OuterCategoryDTO category) {
        OuterCategory outerCategory = categoryRepository.findById(category.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Outer Category", "id", category.getId())
        );
        outerCategory.setName(category.getName());
        categoryRepository.save(outerCategory);

        return outerCategoryMapper.toDTO(outerCategory);
    }

    @Override
    public void deleteOuterCategory(String id) {
        OuterCategory existedCategory = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Outer Category", "id", id)
        );
        categoryRepository.delete(existedCategory);
    }
}
