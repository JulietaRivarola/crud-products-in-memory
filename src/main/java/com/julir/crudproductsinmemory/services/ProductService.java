package com.julir.crudproductsinmemory.services;

import com.julir.crudproductsinmemory.models.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    List<Product> getAllProductsSortedByField(String sortField, String sortOrder);

    Product getProductById(Long id);

    List<Product> getProductByName(String name);

    Product createProduct(Product producto);

    @Transactional
    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);

}
