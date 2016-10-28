package com.product.review.model;

import java.beans.PropertyEditorSupport;

import com.product.review.service.CategoryService;

public class Editor extends PropertyEditorSupport {

    private final CategoryService categoryService;

    public Editor(CategoryService categoryService){
        this.categoryService=categoryService;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        Category category=categoryService.findOne(Long.parseLong(text));
        setValue(category);
    }
}