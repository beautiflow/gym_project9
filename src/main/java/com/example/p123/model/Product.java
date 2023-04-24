package com.example.p123.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Product extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;
    private String name;
    private Category category;
    private LocalDateTime date;
    private String time;
    private String description;

    public Product(String name, Category category, LocalDateTime date, String time, String description) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.time = time;
        this.description = description;
    }
}