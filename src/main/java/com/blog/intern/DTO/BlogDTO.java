package com.blog.intern.DTO;

import jakarta.validation.constraints.NotEmpty;

public class BlogDTO {
    @NotEmpty(message = "Title cannot be empty")
    private String title;
    @NotEmpty(message = "Description cannot be empty")
    private String description;
    @NotEmpty(message = "Category cannot be empty")
    private String category;

    public BlogDTO() {}

    public BlogDTO(String title, String description, String category) {
        this.title = title;
        this.description = description;
        this.category = category;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}