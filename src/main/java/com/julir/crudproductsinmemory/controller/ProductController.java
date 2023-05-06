package com.julir.crudproductsinmemory.controller;

import com.julir.crudproductsinmemory.exceptions.ResourceNotFoundException;
import com.julir.crudproductsinmemory.models.entity.Product;
import com.julir.crudproductsinmemory.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> searchProducts(@RequestParam(required = false) Long id,
                                                        @RequestParam(required = false) String name,
                                                        @RequestParam(defaultValue = "price") String sortBy,
                                                        @RequestParam(defaultValue = "asc") String order) {
        List<Product> products;
        if (id != null) {
            Product product = productService.getProductById(id);
            products = new ArrayList<>();
            products.add(product);
        } else if (name != null) {
            products = productService.getProductByName(name);
        } else {
            products = productService.getAllProductsSortedByField(sortBy, order);
        }
        return ResponseEntity.ok(products);
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product producto) {
        Product newProduct = productService.createProduct(producto);
        return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}
