package com.example.auto.models.enums;

public enum OfferEnum {
    Created(0),
    InProcessing(1),
    Delivery(2),
    Delivered(3),
    Closed(4);
    private int number;

    OfferEnum(int number) {
        this.number = number;
    }
}
