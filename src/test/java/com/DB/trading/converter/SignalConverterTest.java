package com.DB.trading.converter;

import com.DB.trading.service.SignalType;
import org.junit.jupiter.api.Test;

import static com.DB.trading.converter.SignalConverter.getSignalType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignalConverterTest {

    @Test
    void signal_should_map_correctly_for_one() {
        assertEquals(SignalType.ONE, getSignalType(1));
    }

    @Test
    void signal_should_map_correctly_for_two() {
        assertEquals(SignalType.TWO, getSignalType(2));
    }

    @Test
    void signal_should_map_correctly_for_three() {
        assertEquals(SignalType.THREE, getSignalType(3));
    }

    @Test
    void signal_should_map_correctly_for_default() {
        assertEquals(SignalType.DEFAULT, getSignalType(78));
    }

}
