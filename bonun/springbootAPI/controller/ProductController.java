package com.likelion.springbootAPI.controller;

import com.likelion.springbootAPI.Service.ProductServiceImpl;
import com.likelion.springbootAPI.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")

public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") long id) {

        try{
            return ResponseEntity.ok(productService.findById(id));
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try{
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.save(product));
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") long id,
            @RequestBody Product product
    ) {
        try{
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.update(id, product));
        }catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
        try{
            productService.delete(id);
            ResponseEntity.noContent();
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
