package com.example.epam.entity;

public enum RoomType {
    ECONOMY("The cheapest option"),
    BUSINESS("Good price-quality ratio"),
    LUXURY("For real Daddy");
    private String description;

    RoomType(String description) {
        this.description = description;
    }
}
