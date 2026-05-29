package com.travel.booking.designpatterns.strategies;

import com.travel.booking.designpatterns.strategies.interfaces.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " to cash");
    }
}
