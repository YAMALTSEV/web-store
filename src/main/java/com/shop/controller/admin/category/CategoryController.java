package com.shop.controller.admin.category;

import com.shop.model.Category;
import com.shop.model.image.CategoryImage;
import com.shop.repository.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String addCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return BASE_PATH + "add-category";
    }

    @PostMapping("categories/add")
    public String saveCategory(@ModelAttribute("category") Category category,
                               @RequestParam("img_path") String img_path) {
        category.setImage(new CategoryImage(img_path));
        categoryRepository.save(category);
        return "redirect:" + BASE_PATH;
    }
}
