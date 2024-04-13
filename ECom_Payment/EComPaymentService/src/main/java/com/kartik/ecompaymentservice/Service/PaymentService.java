package com.kartik.ecompaymentservice.Service;

import com.kartik.ecompaymentservice.PaymentGateway.PaymentGateway;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway)
    {
        this.paymentGateway=paymentGateway;
    }

    public String makepayment(Long orderid, Long amount) throws StripeException {
        String link =paymentGateway.generatepaymentlink(orderid,amount);
        return link;
    }
}
