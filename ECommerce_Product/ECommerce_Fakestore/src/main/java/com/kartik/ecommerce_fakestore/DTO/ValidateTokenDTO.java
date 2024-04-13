package com.kartik.ecommerce_fakestore.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenDTO
{

        private Long userID;
        private String token;

        public ValidateTokenDTO()
        {
        }

        public ValidateTokenDTO(Long userID, String token)
        {
            this.userID=userID;
            this.token = token;
        }

}
