package com.kartik.ecommerce_fakestore.Repository;

import com.kartik.ecommerce_fakestore.Models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, Long> {
}
