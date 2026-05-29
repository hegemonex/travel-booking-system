package com.travel.booking.designpatterns.strategies;

import com.travel.booking.designpatterns.strategies.interfaces.PaymentStrategy;

public class PaymentContext {

    private PaymentStrategy  strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        strategy.pay(amount);
    }
}
