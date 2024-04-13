package com.example.ecomorder.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderResponseDTO {
 private Long orderid;
 private Long userid;
 private List<Long> productids;
}
