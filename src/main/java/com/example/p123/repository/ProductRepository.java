package com.example.p123.repository;

//import com.example.p123.entity.Category;
import com.example.p123.model.Category;
import com.example.p123.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByName(String name);


    List<Product> findByCategory(Category category);

    @Query("SELECT p FROM Product p ORDER BY p.product_id desc")
    Page<Product> findAllDesc(Pageable pageable);
}