package com.accumenta.Knowledge_Hub_Portal.serviceimpl;

import com.accumenta.Knowledge_Hub_Portal.exception.CategoryPageAlreadyExceptionExists;
import com.accumenta.Knowledge_Hub_Portal.model.CategoryPage;
import com.accumenta.Knowledge_Hub_Portal.repository.CategoryPageRepository;
import com.accumenta.Knowledge_Hub_Portal.service.CategoryPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryPageSeriveImpl  implements CategoryPageService {
    @Autowired
    private CategoryPageRepository categoryPageRepository;

    @Override
    public CategoryPage addCategoryPage(CategoryPage categoryPage) {
        CategoryPage dbCategoryPage = this.categoryPageRepository.findById(categoryPage.getId()).orElse(null);
        if (dbCategoryPage  == null) {
            return this.categoryPageRepository.save(categoryPage);
        } else {
            throw new CategoryPageAlreadyExceptionExists("CategoryPage Id is not found");
        }
    }

    @Override
    public boolean deleteCategoryPage(long id) {
        CategoryPage dbCategoryPage = this.categoryPageRepository.findById(id).get();
        if (dbCategoryPage != null) {
            this.categoryPageRepository.delete(dbCategoryPage);
            return true;
        } else {
            throw new CategoryPageAlreadyExceptionExists("Categorypage Id Already Exists");
        }
    }

    @Override
    public CategoryPage getCategoryPageById(long id) {
        CategoryPage dbCategoryPage = this.categoryPageRepository.findById(id).get();
        if (dbCategoryPage != null) {
            return this.categoryPageRepository.findById(id).get();
        } else {
            throw new CategoryPageAlreadyExceptionExists("CategoryPage Id Already Exists");

        }
    }

    @Override
    public CategoryPage updateCategoryPage(long id, CategoryPage categoryPage) {
        CategoryPage dbCategoryPage = this.categoryPageRepository.findById(id).get();
        if (dbCategoryPage != null) {
            dbCategoryPage.setId(id);
            dbCategoryPage.setCategory(categoryPage.getCategory());
            dbCategoryPage.setDescription(categoryPage.getDescription());
            return this.categoryPageRepository.save(dbCategoryPage);
        } else {
            throw new CategoryPageAlreadyExceptionExists("Already exists");
        }

    }


    @Override
    public List<CategoryPage> getAllCategoryPages() {
        return this.categoryPageRepository.findAll();
    }
}
