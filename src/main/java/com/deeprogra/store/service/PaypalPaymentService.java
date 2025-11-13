package com.deeprogra.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PaypalPaymentService implements PaymentService {

    Logger logger = LoggerFactory.getLogger(PaypalPaymentService.class);

    @Override
    public void processPayment(double amount) {
        logger.info("PAYPAL");
        logger.debug("Amount: " + amount);
    }

}
