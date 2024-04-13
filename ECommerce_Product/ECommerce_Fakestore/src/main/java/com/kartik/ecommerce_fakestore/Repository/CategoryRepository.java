package com.kartik.ecommerce_fakestore.Repository;

import com.kartik.ecommerce_fakestore.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository <Category, Long> {
}
