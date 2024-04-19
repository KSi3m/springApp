package org.example.services;

import org.example.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    public void saveCategory(Category category);
    public Category getCategory(int categoryid);
    public void deleteCategory(int categoryid);

    List<Category> getUndeletedCategories();
}
