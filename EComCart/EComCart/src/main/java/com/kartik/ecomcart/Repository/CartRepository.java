package com.kartik.ecomcart.Repository;

import com.kartik.ecomcart.Model.Cart;
import com.kartik.ecomcart.Model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartRepository extends CrudRepository<Cart,Long> {
    public Cart findByUserId(Long id);
   @Transactional
   @Modifying
    @Query(value="delete from Cart_Products where products_id=:productId",nativeQuery = true)
    public void deleteFromCartProductsByProductId(Long productId);

}
