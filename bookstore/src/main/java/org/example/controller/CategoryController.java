package org.example.controller;


import org.example.dto.CategoryDTO;
import org.example.entity.Category;
import org.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getUndeletedCategories();
        model.addAttribute("categories", categories);
        return "catgslist";
    }
    @GetMapping("/add")
    public String addForm(Model model)
    {
        CategoryDTO categoryDTO = new CategoryDTO();
        model.addAttribute("categoryDTO",categoryDTO);
        return "addcatform";
    }
    @PostMapping("/saveCategory")
    public String saveBook(@ModelAttribute("categoryDTO") CategoryDTO categoryDTO)
    {
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        category.setStatus(categoryDTO.getStatus());
        categoryService.saveCategory(category);
        return "redirect:/categories/list";
    }
    @GetMapping("/updateCategoryForm")
    public String updateCategoryForm(@RequestParam("categoryId")int categoryId, Model model){

        Category category = categoryService.getCategory(categoryId);
        CategoryDTO categoryDTO = new CategoryDTO();

        if(category != null)
        {
            categoryDTO.setId(category.getId());
            categoryDTO.setName(category.getName());
            categoryDTO.setStatus(category.getStatus());
        }

        model.addAttribute("categoryDTO",categoryDTO);
        return "addcatform";
    }
    @GetMapping("/deleteCategoryForm")
    public String deleteCategoryForm(@RequestParam("categoryId")int categoryId, Model model){
        Category category = categoryService.getCategory(categoryId);
        model.addAttribute("category",category);
        return "deletecategoryform";

    }
    @PostMapping("/deleteCategory")
    public String deleteCategory(@ModelAttribute("category") Category category){
        categoryService.deleteCategory(category.getId());
        return "redirect:/categories/list";
    }
}
