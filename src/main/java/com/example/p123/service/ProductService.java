package com.example.p123.service;

import com.example.p123.model.Category;
import com.example.p123.model.Product;
import com.example.p123.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않습니다."));
    }

    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    public Page<Product> getAllProducts(Pageable pageable) {
        return productRepository.findAllDesc(pageable);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(String name, Category category, String day, String time, String description) {
        var product = new Product(name, category, day, time, description);
        return productRepository.save(product);
    }
}