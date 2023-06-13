package com.shop.controller.admin.product;

import com.shop.model.Category;
import com.shop.model.Product;
import com.shop.repository.CategoryRepository;
import com.shop.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    private final String BASE_PATH = "admin/products/";
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductRepository productRepository,
                             CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping()
    public String showProducts(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return BASE_PATH + "show-products";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return BASE_PATH + "add-product";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productRepository.save(product);
        return "redirect:/admin/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long productId, Model model) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()) return "redirect:/admin/products";
        model.addAttribute("product", product.get());
        return BASE_PATH + "delete-product";
    }

    @PostMapping("/delete/{id}")
    public String confirmDeleteProduct(@PathVariable("id") Long productId) {
        productRepository.deleteById(productId);
        return "redirect:/admin/products";
    }

    @GetMapping("/update/{id}")
    public String updateProduct(@PathVariable("id") Long productId, Model model) {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()) return "redirect:/admin/products";
        model.addAttribute("product", product.get());
        return BASE_PATH + "add-product";
    }
}
