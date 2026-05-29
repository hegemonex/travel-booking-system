package com.travel.booking.designpatterns.strategies;

import com.travel.booking.designpatterns.strategies.interfaces.PaymentStrategy;

public class CardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " via card");
    }
}
