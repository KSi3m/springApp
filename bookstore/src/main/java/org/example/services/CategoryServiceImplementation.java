package org.example.services;

import org.example.dao.CategoryDAO;
import org.example.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImplementation implements CategoryService {


    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    @Transactional
    public List<Category> getCategories() {
        List<Category> categories = categoryDAO.getCategories();
        return categories;
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryDAO.saveCategory(category);
    }

    @Override
    @Transactional
    public Category getCategory(int categoryid) {
        return categoryDAO.getCategory(categoryid);
    }

    @Override
    @Transactional
    public void deleteCategory(int categoryid) {
        categoryDAO.deleteCategory(categoryid);
    }

    @Override
    @Transactional
    public List<Category> getUndeletedCategories() {
        return categoryDAO.getUndeletedCategories();
    }

}
