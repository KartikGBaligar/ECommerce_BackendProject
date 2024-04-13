package com.example.ecomorder.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderRequestDTO {
    private Long userid;
    private Long[] productids;
}
