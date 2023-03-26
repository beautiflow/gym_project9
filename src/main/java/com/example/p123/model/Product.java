package com.example.p123.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;
    private String name;
    private Category category;
    private String day;
    private String time;
    private String description;

    public Product(String name, Category category, String day, String time, String description) {
        this.name = name;
        this.category = category;
        this.day = day;
        this.time = time;
        this.description = description;
    }
}