package com.example.ecomorder.Repository;

import com.example.ecomorder.DTO.OrderResponseDTO;
import com.example.ecomorder.Model.EComOrder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EComOrderRepository extends CrudRepository<EComOrder,Long> {

//    @Transactional
//    @Modifying
//    @Query(value="select id from ecom_order_products where products_id=:productId",nativeQuery = true)
    public List<EComOrder> findByUserId(Long productId);
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO ecom_order_products (ecom_order_id, products_id) VALUES (:orderid,:productsid)", nativeQuery = true)
    public void insert(@Param("orderid") Long orderid, @Param("productsid")Long productsid);
}
