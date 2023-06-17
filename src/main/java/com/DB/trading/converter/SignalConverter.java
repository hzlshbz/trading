package com.DB.trading.converter;

import com.DB.trading.service.SignalType;

import java.util.Arrays;

public class SignalConverter {

    public static SignalType getSignalType(int signalId) {
        return Arrays.stream(SignalType.values())
                .filter(signal -> signal.getValue() == signalId)
                .findFirst()
                .orElse(SignalType.DEFAULT);
    }
}
