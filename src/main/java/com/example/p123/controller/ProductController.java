package com.example.p123.controller;

import com.example.p123.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;


    @GetMapping("/api/product/{id}")
    public String productPage(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        return "product";
    }

    @GetMapping("/api/products")
    public String productsPage(Model model,
                               @PageableDefault(size = 10) Pageable pageable) {

        var products = productService.getAllProducts(pageable);
        model.addAttribute("products", products);
        return "product-list";
    }

    @GetMapping("/api/new-product")
    public String newProductPage() {
        return "new-product";
    }

    @PostMapping("/api/products")
    public String newProduct(@ModelAttribute CreateProductRequest createProductRequest) {
        productService.createProduct(
                createProductRequest.getName(),
                createProductRequest.getCategory(),
                createProductRequest.getDay(),
                createProductRequest.getTime(),
                createProductRequest.getDescription());
        return "redirect:/";
    }
}
