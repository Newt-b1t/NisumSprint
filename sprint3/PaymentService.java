//6
package com.avinash.sprint3;


final class InvalidPaymentMethodException extends PaymentException {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}

final class InvalidOfferAppliedException extends PaymentException {
    public InvalidOfferAppliedException(String message) {
        super(message);
    }
}

public class PaymentService {

    public void paymentMethod(String paymentType, String offerCode) throws PaymentException {
        if (!paymentType.equalsIgnoreCase("credit") &&
                !paymentType.equalsIgnoreCase("debit") &&
                !paymentType.equalsIgnoreCase("upi")) {
            throw new InvalidPaymentMethodException("Unsupported payment method: " + paymentType);
        }

        if (offerCode != null && offerCode.equalsIgnoreCase("INVALID-OFFER")) {
            throw new InvalidOfferAppliedException("Invalid offer applied: " + offerCode);
        }

        System.out.println("Payment processed using " + paymentType + " with offer: " + offerCode);
    }

    public void processPaymentMethod(String paymentType, String offerCode) {
        try {
            paymentMethod(paymentType, offerCode);
        } catch (PaymentException e) {
            // Pattern matching in catch block (Java 16+)
            if (e instanceof InvalidPaymentMethodException ime) {
                System.out.println("Payment Error: " + ime.getMessage());
            } else if (e instanceof InvalidOfferAppliedException ioe) {
                System.out.println("Offer Error: " + ioe.getMessage());
            } else {
                System.out.println("Unknown Payment Exception: " + e.getMessage());
            }
        }

        System.out.println("End of payment processing.");
    }

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        paymentService.processPaymentMethod("credit", "DISCOUNT10");
        paymentService.processPaymentMethod("cheque", "DISCOUNT10");      // Invalid payment method
        paymentService.processPaymentMethod("debit", "INVALID-OFFER");    // Invalid offer
    }
}

