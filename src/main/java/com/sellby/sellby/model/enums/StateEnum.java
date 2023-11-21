package com.sellby.sellby.model.enums;

public enum StateEnum {
    LIKE_NEW("Like new"),
    GOOD("Good"),
    OKAY("Okay"),
    BAD("Bad");

    private final String displayValue;

    private StateEnum(String displayValue) {
        this.displayValue = displayValue;
    }

    @Override
    public String toString() {
        return displayValue;
    }
}
