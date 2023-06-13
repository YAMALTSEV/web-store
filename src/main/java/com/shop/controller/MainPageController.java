package com.shop.controller;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final ProductRepository productRepository;

    public MainPageController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @GetMapping
    public String getMainPage(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "index";
    }

}
