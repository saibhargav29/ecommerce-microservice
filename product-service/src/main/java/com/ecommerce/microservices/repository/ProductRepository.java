package com.ecommerce.microservices.repository;

import com.ecommerce.microservices.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {

    void deleteBySkuCode(String skuCode);

    boolean existsBySkuCode(String skuCode);

    Optional<Product> findByName(String name);
}
