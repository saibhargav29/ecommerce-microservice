package com.ecommerce.microservices.controller;

import com.ecommerce.microservices.dto.ProductRequest;
import com.ecommerce.microservices.dto.ProductResponse;
import com.ecommerce.microservices.model.Product;
import com.ecommerce.microservices.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest){
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
//        try{
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return productService.getAllProducts();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@RequestParam String skuCode){
        return productService.deleteProduct(skuCode);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String updateProduct(@RequestParam String name, @RequestParam String updateSkuCode) {
        return productService.updateProduct(name, updateSkuCode);
    }




}
