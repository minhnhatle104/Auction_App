package com.auction.backendauction.service.impl;

import com.auction.backendauction.dto.InnerCategoryDTO;
import com.auction.backendauction.entity.InnerCategory;
import com.auction.backendauction.exception.impl.InnerCategoryAlreadyExists;
import com.auction.backendauction.exception.impl.ResourceNotFoundException;
import com.auction.backendauction.mapper.InnerCategoryMapper;
import com.auction.backendauction.repository.InnerCategoryRepository;
import com.auction.backendauction.service.InnerCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InnerCategoryServiceImpl implements InnerCategoryService {

    @Autowired
    private InnerCategoryRepository categoryRepository;

    @Autowired
    private InnerCategoryMapper innerCategoryMapper;

    @Override
    public InnerCategoryDTO createInnerCategory(InnerCategoryDTO innerCategory) {
        Optional<InnerCategory> existingCategory = categoryRepository.findByName(innerCategory.getName());
        if (existingCategory.isPresent()) {
            throw new InnerCategoryAlreadyExists("Inner Category already exists");
        }
        InnerCategory category = innerCategoryMapper.toEntity(innerCategory);
        InnerCategory savedCategory = categoryRepository.save(category);

        InnerCategoryDTO savedCategoryDTO = innerCategoryMapper.toDTO(savedCategory);

        return savedCategoryDTO;
    }

    @Override
    public List<InnerCategoryDTO> getListCategory() {
        List<InnerCategory> categories = categoryRepository.findAll();

        return categories.stream().map(innerCategoryMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public InnerCategoryDTO getCategoryById(String id) {
        InnerCategory existingCategory = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Inner Category","id",id)
        );
        return innerCategoryMapper.toDTO(existingCategory);
    }

    @Override
    public InnerCategoryDTO updateCategory(InnerCategoryDTO innerCategory) {
        InnerCategory existingCategory = categoryRepository.findById(innerCategory.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Inner Category","id",innerCategory.getId())
        );
        existingCategory.setName(innerCategory.getName());
        categoryRepository.save(existingCategory);
        return innerCategoryMapper.toDTO(existingCategory);
    }

    @Override
    public void deleteInnerCategory(String id) {
        InnerCategory existingCategory = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Inner Category","id",id)
        );
        categoryRepository.delete(existingCategory);
    }

}
