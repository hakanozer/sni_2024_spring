package com.works.overview.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.works.overview.entities.Product;
import com.works.overview.models.ModelProduct;
import com.works.overview.services.ProductService;
import com.works.overview.utils.Util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequiredArgsConstructor
@RequestMapping("product")
public class ProductRestController {

    final ProductService productService;
    final HttpServletRequest req;

    @PostMapping("save")
    public ResponseEntity save(@RequestBody ModelProduct product) {        
        return productService.save(product);
    }

    @GetMapping("list")
    public ResponseEntity list() {
        return productService.list();
    }
    
    
    
}
