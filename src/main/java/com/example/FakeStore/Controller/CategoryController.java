package com.example.FakeStore.Controller;

import com.example.FakeStore.DTO.ProductDTO;
import com.example.FakeStore.Service.ICategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/Product/Category")
public class CategoryController {

    private final ICategoryService iCategoryService;

    public CategoryController(ICategoryService _iCategoryService){
        this.iCategoryService=_iCategoryService;
    }

    @GetMapping
    public List<ProductDTO> getAllCategories(){
        return iCategoryService.getAllCategory();
    }
}
