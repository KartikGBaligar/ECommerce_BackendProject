package com.kartik.ecommerce_fakestore.DTO;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRequestDTO {
    private int ID;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
