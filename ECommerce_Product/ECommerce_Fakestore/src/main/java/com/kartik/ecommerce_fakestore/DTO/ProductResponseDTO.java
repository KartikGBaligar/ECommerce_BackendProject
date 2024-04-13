package com.kartik.ecommerce_fakestore.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ProductResponseDTO {
    private Long ID;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
    //private String colour;

    //colour attribute is not present in Fakestore. Hence, colour:null is returned

}
