package com.accumenta.Knowledge_Hub_Portal.controller;

import com.accumenta.Knowledge_Hub_Portal.dto.ResponseWrapper;
import com.accumenta.Knowledge_Hub_Portal.model.CategoryPage;
import com.accumenta.Knowledge_Hub_Portal.service.CategoryPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryPageController {
    @Autowired
    private CategoryPageService categoryPageService;
    @PostMapping(value = "/saveCategory", produces = "application/json")
    public ResponseEntity<ResponseWrapper> saveCategoryPage(@RequestBody CategoryPage categoryPage) {
        CategoryPage dbCategoryPage1 = this.categoryPageService.addCategoryPage(categoryPage);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbCategoryPage1));
    }
    @GetMapping(value = "/getcategory/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> getCategoryUrls(@PathVariable long id,@RequestBody CategoryPage categoryPage) {
        CategoryPage dbCategoryPage = this.categoryPageService.getCategoryPageById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbCategoryPage));
    }
    @PutMapping(value = "/updatecategory/{id}", produces = "application/json")
    public ResponseEntity<ResponseWrapper> updateCategoryPage(@RequestBody CategoryPage categoryPage, @PathVariable long id) {
        CategoryPage bdcategoryPage = this.categoryPageService.updateCategoryPage(id, categoryPage);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(bdcategoryPage));
    }
    @DeleteMapping(value = "/delcategory/{id}",produces="application/json")
    public ResponseEntity<ResponseWrapper> deleteCatagoryPage(@PathVariable long id) {
        boolean dbcategotyPage =this.categoryPageService.deleteCategoryPage(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbcategotyPage));
    }
    @GetMapping(value = "/getallcategory",produces="application/json")
    public ResponseEntity<ResponseWrapper> getAllCategory() {
        List<CategoryPage> dbCategoryPages=this.categoryPageService.getAllCategoryPages();
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseWrapper(dbCategoryPages));
    }
}



