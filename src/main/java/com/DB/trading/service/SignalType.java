package com.DB.trading.service;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum SignalType {
    DEFAULT(0),
    ONE(1),
    TWO(2),
    THREE(3);

    private final int value;

    public int getValue() {
        return value;
    }
}
