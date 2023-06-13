package com.shop.controller.admin;

import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.model.image.CategoryImage;
import com.shop.repository.CategoryRepository;
import com.shop.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public AdminPanelController(ProductRepository productRepository,
                                CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    public String showAdminPanel() {
        return "admin/admin-panel";
    }

}
