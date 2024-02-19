package com.fsd.test.controllers;

import com.fsd.test.beans.ResponseHandler;
import com.fsd.test.entities.Product;
import com.fsd.test.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllProducts() {
        return ResponseHandler.generateResponse("All Products",
                HttpStatus.OK,
                productService.getAllProducts()
        );
    }

    @GetMapping("getProduct/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Long id) {
        return ResponseHandler.generateResponse("Product Found",
                HttpStatus.OK,
                productService.getProduct(id)
        );
    }

    @PostMapping("createProduct")
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        return ResponseHandler.generateResponse("Product Created Successfully",
                HttpStatus.CREATED,
                productService.createProduct(product)
        );
    }

    @DeleteMapping("deleteProduct/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        return ResponseHandler.generateResponse("Product Deleted Successfully",
                HttpStatus.OK,
                productService.deleteProduct(id)
        );
    }

    @DeleteMapping("deleteAll")
    public ResponseEntity<Object> deleteAll() {
        productService.deleteAll();
        return ResponseHandler.generateResponse("All Products Deleted Successfully",
                HttpStatus.OK,
                null
        );
    }

    @PutMapping("updateProduct")
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        return ResponseHandler.generateResponse("Product Updated Successfully",
                HttpStatus.OK,
                productService.updateProduct(product)
        );
    }
}
