package com.example.p123.service;

import com.example.p123.model.Category;
import com.example.p123.model.Product;
import com.example.p123.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
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

    public Product createProduct(String name, Category category, String date, String time, String description) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);
        log.info(localDateTime.toString());
        var product = new Product(name, category, localDateTime, time, description);
        return productRepository.save(product);
    }
}