package com.example.auto.models.enums;

public enum EngineEnum {
    GASOLINE (0),
    DIESEL (1),
    ELECTRIC (2),
    HYBRID (3);
    private int number;

    EngineEnum(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
