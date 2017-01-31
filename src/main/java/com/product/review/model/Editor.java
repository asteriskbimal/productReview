package com.product.review.model;

import java.beans.PropertyEditorSupport;

import com.product.review.service.Service;

public class Editor extends PropertyEditorSupport {

    private final Service service;

    public Editor(Service service){
        this.service=service;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
    	setValue(service.findOne(Long.parseLong(text)));
    }
}