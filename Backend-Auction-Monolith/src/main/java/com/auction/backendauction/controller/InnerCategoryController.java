package com.auction.backendauction.controller;

import com.auction.backendauction.dto.InnerCategoryDTO;
import com.auction.backendauction.service.InnerCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/inner-categories")
@AllArgsConstructor
public class InnerCategoryController {

    private InnerCategoryService categoryService;

    @PostMapping("{outer-id}")
    public ResponseEntity<InnerCategoryDTO> createCategory(@PathVariable("outer-id") String outerId,
                                                           @RequestBody InnerCategoryDTO innerCategoryDTO) {
        innerCategoryDTO.setOuterCategoryId(outerId);
        InnerCategoryDTO savedCategory = categoryService.createInnerCategory(innerCategoryDTO);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<InnerCategoryDTO>> getListCategory() {
        List<InnerCategoryDTO> categories = categoryService.getListCategory();
        System.out.println(categories.toString());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<InnerCategoryDTO> getCategoryById(@PathVariable("id") String id) {
        InnerCategoryDTO categoryDTO = categoryService.getCategoryById(id);
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<InnerCategoryDTO> updateCategory(@PathVariable("id") String id,
                                                           @RequestBody InnerCategoryDTO innerCategoryDTO) {
        innerCategoryDTO.setId(id);
        InnerCategoryDTO updatedCategory = categoryService.updateCategory(innerCategoryDTO);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") String id) {
        categoryService.deleteInnerCategory(id);
        return new ResponseEntity<>("Delete inner category with id " + id, HttpStatus.OK);
    }
}
