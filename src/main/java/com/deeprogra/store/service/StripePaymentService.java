package com.deeprogra.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StripePaymentService implements PaymentService {

    Logger logger = LoggerFactory.getLogger(StripePaymentService.class);

    @Override
    public void processPayment(double amount) {
        logger.info("STRIPE");
        logger.debug("Amount: " + amount);
    }

}
