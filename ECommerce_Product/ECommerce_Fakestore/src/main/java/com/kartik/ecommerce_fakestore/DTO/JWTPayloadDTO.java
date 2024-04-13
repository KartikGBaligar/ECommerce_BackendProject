package com.kartik.ecommerce_fakestore.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JWTPayloadDTO
{
        @JsonProperty("createdAt")
        private long createdAt;
//        @JsonProperty("roles")
//        private String roles;
        @JsonProperty("expiryAt")
        private long expiryAt;
        @JsonProperty("userID")
        private Long userID;
}
