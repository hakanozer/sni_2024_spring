package com.works.overview.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class ModelProduct implements Serializable {

    private Long pid;
    private String title;
    private Integer price;
    
}
