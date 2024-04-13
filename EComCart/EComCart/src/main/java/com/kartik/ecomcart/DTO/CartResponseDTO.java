package com.kartik.ecomcart.DTO;


import com.kartik.ecomcart.Model.Product;
import com.kartik.ecomcart.Model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartResponseDTO {
    private  Long cartid;
    private Long userid;
    private Long productid;
}
