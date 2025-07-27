package com.example.FakeStore.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category  extends  BaseEntity{

     private String name;

     @OneToMany(mappedBy = "category")
     private List<Product> products;

}
