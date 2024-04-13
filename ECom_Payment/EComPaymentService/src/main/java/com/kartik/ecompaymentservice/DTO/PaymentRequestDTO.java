package com.kartik.ecompaymentservice.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class PaymentRequestDTO {
    private long orderid;
    private long amount;
}
