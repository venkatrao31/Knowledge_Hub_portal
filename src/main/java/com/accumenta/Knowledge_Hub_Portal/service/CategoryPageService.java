package com.accumenta.Knowledge_Hub_Portal.service;

import com.accumenta.Knowledge_Hub_Portal.model.CategoryPage;

import java.util.List;

public interface CategoryPageService {
    CategoryPage addCategoryPage(CategoryPage categoryPage);
    boolean deleteCategoryPage(long id);
    CategoryPage getCategoryPageById(long id);
    CategoryPage updateCategoryPage(long id, CategoryPage categoryPage);
    List<CategoryPage> getAllCategoryPages();


}
