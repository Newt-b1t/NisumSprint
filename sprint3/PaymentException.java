package com.avinash.sprint3;

// 1️⃣ Define the sealed exception hierarchy
public sealed class PaymentException extends Exception
        permits InvalidPaymentMethodException, InvalidOfferAppliedException {
    public PaymentException(String message) {
        super(message);
    }
}
