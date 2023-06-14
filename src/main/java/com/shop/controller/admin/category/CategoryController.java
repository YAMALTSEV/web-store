package com.shop.controller.admin.category;

import com.shop.model.Category;
import com.shop.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/categories")
public class CategoryController {

    private final String BASE_PATH = "admin/categories/";
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    public String showCategories(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return BASE_PATH + "show-categories";
    }

    @GetMapping("/add")
    public String showAddCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        model.addAttribute("buttonName", "Добавить");
        return BASE_PATH + "add-category";
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryRepository.save(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable("id") int categoryId, Model model) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isEmpty()) return "redirect:/admin/categories";
        model.addAttribute("category", category.get());
        return BASE_PATH + "delete-category";
    }

    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int categoryId) {
        categoryRepository.deleteById(categoryId);
        return "redirect:/admin/categories";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable("id") int categoryId, Model model) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isEmpty()) return "redirect:/admin/categories";
        model.addAttribute("category", category.get());
        model.addAttribute("buttonName", "Обновить");
        return BASE_PATH + "/add-category";
    }

}
