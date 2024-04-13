package com.kartik.ecomcart.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private User user;
    @ManyToMany
    private List<Product> products = new ArrayList<Product>();
}
