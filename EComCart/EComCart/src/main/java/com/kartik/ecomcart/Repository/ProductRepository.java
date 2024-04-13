package com.kartik.ecomcart.Repository;

import com.kartik.ecomcart.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
