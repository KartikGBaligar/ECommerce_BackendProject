package com.example.ecomorder.Repository;

import com.example.ecomorder.Model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends CrudRepository<Product, Long> {
//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO ecom_order_products (ecom_order_id, products_id) VALUES (:orderid,:productsid)", nativeQuery = true)
//    public void insert(@Param("orderid") Long orderid, @Param("productsid")Long productsid);
}
