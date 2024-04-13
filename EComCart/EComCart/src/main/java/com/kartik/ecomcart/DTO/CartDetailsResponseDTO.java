package com.kartik.ecomcart.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDetailsResponseDTO {
    private Long cartid;
    private Long userid;
    private List<Long> productIds;
}
