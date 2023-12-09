package com.example.auto.models.enums;

public enum TransmissionEnum {
    MANUAL (0, "Механическая"),
    AUTOMATIC (1, "Автоматическая");
    private int number;
    private String name;

    TransmissionEnum(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}