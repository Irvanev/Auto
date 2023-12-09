package com.example.auto.models.enums;

public enum EngineEnum {
    GASOLINE (0, "Бензин"),
    DIESEL (1, "Дизель"),
    ELECTRIC (2, "Электрический"),
    HYBRID (3, "Гибрид");
    private int number;
    private String name;

    EngineEnum(int number, String name) {
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
