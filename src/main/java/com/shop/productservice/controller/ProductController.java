package com.shop.productservice.controller;

import com.shop.productservice.dto.ProductRequest;
import com.shop.productservice.dto.ProductResponse;
import com.shop.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        log.info("New product created");
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@RequestParam String id){
        productService.deleteProduct(id);
        log.info("Product deleted with id : " + id);
    }
}
