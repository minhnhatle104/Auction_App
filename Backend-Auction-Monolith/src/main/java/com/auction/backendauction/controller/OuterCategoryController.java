package com.auction.backendauction.controller;

import com.auction.backendauction.dto.OuterCategoryDTO;
import com.auction.backendauction.entity.OuterCategory;
import com.auction.backendauction.service.OuterCategoryService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/outer-categories")
@AllArgsConstructor
public class OuterCategoryController {

    private OuterCategoryService outerCategoryService;

    @PostMapping("")
    public ResponseEntity<OuterCategoryDTO> createOuterCategory(@RequestBody OuterCategoryDTO categoryDTO){
        OuterCategoryDTO savedCategory = outerCategoryService.createOuterCategory(categoryDTO);
        return new ResponseEntity<>(savedCategory,HttpStatus.CREATED);
    }


    @GetMapping("")
    public ResponseEntity<List<OuterCategoryDTO>> getListOuterCategories(){
        List<OuterCategoryDTO> categories = outerCategoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OuterCategoryDTO> getOuterCategoryById(@PathVariable("id") String id){
        OuterCategoryDTO outerCategoryDTO = outerCategoryService.getCategoryById(id);
        return new ResponseEntity<>(outerCategoryDTO,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OuterCategoryDTO> updateCategory(@PathVariable("id") String id,
            @RequestBody OuterCategoryDTO categoryDTO){
        categoryDTO.setId(id);
        OuterCategoryDTO updatedCategory = outerCategoryService.updateCategory(categoryDTO);
        return new ResponseEntity<>(updatedCategory,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") String id){
        outerCategoryService.deleteOuterCategory(id);
        return new ResponseEntity<>("Delete outer category successfully !", HttpStatus.OK);
    }
}
