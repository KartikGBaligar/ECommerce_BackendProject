package com.kartik.ecompaymentservice.PaymentGateway;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    public String generatepaymentlink(Long orderid, Long amount) throws StripeException;
}
