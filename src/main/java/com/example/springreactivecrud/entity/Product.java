package com.example.springreactivecrud.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {


     @Id
      private Integer id;
     @Column
      private String name ;
     @Column
      private String price ;
}
