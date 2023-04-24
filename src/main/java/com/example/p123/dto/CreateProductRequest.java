package com.example.p123.dto;

import com.example.p123.model.Category;
import lombok.*;

@NoArgsConstructor
@Getter
public class CreateProductRequest {
    private String name;
    private Category category;
    private String date;
    private String time;
    private String description;

    public CreateProductRequest(String name, Category category, String date, String time, String description) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}