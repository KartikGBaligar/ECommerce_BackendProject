package com.kartik.ecompaymentservice.Controller;

import com.kartik.ecompaymentservice.DTO.PaymentRequestDTO;
import com.kartik.ecompaymentservice.Service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService)
    {
        this.paymentService=paymentService;
    }

    @PostMapping
    public ResponseEntity<String> initiatepayment(@RequestBody PaymentRequestDTO paymentRequestDTO) throws StripeException {
        String link = paymentService.makepayment(paymentRequestDTO.getOrderid(), paymentRequestDTO.getAmount());
        return new ResponseEntity<>(link,HttpStatus.OK);
    }
}
