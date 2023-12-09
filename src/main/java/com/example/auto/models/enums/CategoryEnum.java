package com.example.auto.models.enums;

public enum CategoryEnum {
    Car (0, "Автомобиль"),
    Bus (1, "Автобус"),
    Truck (2, "Грузовик"),
    Motorcycle (3, "Мотоцикл");
    private int number;
    private String name;

    CategoryEnum(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
