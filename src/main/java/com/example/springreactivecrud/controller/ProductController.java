package com.example.springreactivecrud.controller;

import com.example.springreactivecrud.entity.Product;
import com.example.springreactivecrud.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
public class ProductController {


     @Autowired
     private ProductRepo productRepo;
    @GetMapping("/findAll")
    public Flux<Product> getAllProduct(){

       return   productRepo.findAll();
    }
    @GetMapping("/product/{id}")
    public Mono<Product> getProductById(@PathVariable int id ){

        return   productRepo.findById(id);
    }

    @PostMapping("/insert")
    public Mono<Product> insertProduct(@RequestBody  Product product){

      return productRepo.save(product);
    }



    @PutMapping("/update/{id}")
    public Mono<Product> updateProductById(@RequestBody Product product , @PathVariable int id ){

        return   productRepo.findById(id)
                .map(
                (c)->{
                    c.setName(product.getName());
                    c.setPrice(product.getPrice());
                    return c ;
                }).flatMap(c->productRepo.save(c));
    }

    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteById(@PathVariable int id ){

         return productRepo.deleteById(id);
    }
}
