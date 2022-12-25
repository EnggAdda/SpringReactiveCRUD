package com.example.springreactivecrud.repo;

import com.example.springreactivecrud.entity.Product;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepo extends ReactiveCrudRepository<Product,Integer> {
}
