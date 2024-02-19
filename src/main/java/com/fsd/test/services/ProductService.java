package com.fsd.test.services;

import com.fsd.test.entities.Product;
import com.fsd.test.exceptions.EntityAlredyExistException;
import com.fsd.test.exceptions.EntityNotFoundException;
import com.fsd.test.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Product not found with given id."));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product) {
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isPresent()) {
            Product productToUpdate = optionalProduct.get();
            productToUpdate.setName(product.getName());
            productToUpdate.setDescription(product.getDescription());
            productToUpdate.setPrice(product.getPrice());
            return productRepository.save(productToUpdate);
        }
        throw new EntityNotFoundException("Product not found with given id.");
    }

    public Product deleteProduct(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product productToDelete = optionalProduct.get();
            productRepository.delete(productToDelete);
            return productToDelete;
        }
        throw new EntityNotFoundException("Product not found with given id.");
    }

    public void deleteAll() { productRepository.deleteAll(); }
}
