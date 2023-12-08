package com.example.auto.models.enums;

public enum CategoryEnum {
    Car (0),
    Bus (1),
    Truck (2),
    Motorcycle (3);
    private int number;

    CategoryEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
