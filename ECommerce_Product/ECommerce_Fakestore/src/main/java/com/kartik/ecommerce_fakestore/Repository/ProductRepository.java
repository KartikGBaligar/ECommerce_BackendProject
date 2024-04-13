package com.kartik.ecommerce_fakestore.Repository;

import com.kartik.ecommerce_fakestore.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
