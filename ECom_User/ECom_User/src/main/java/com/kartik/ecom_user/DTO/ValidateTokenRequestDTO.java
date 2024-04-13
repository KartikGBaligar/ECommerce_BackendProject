package com.kartik.ecom_user.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ValidateTokenRequestDTO {
    private Long userID;
    private String token;
}
