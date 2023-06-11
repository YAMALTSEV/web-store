package com.shop.controller;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminPanelController {

    private final ProductRepository productRepository;

    public AdminPanelController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    private String showAdminPanel() {
        return "admin-panel";
    }

    @GetMapping("/products")
    private String showProducts(Model model) {
        List<Product> products =
        return "admin-products";
    }

}
