package com.DB.trading.factory;

import com.DB.trading.factory.SignalServiceFactory;
import com.DB.trading.service.DefaultSignalService;
import com.DB.trading.service.FirstSignalService;
import com.DB.trading.service.SecondSignalService;
import com.DB.trading.service.SignalService;
import com.DB.trading.service.SignalType;
import com.DB.trading.service.ThirdSignalService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SignalServiceFactoryTest {

    @Test
    void should_create_correct_signal_service_for_received_signal_1() {
        SignalService signalService = SignalServiceFactory.getSignalService(SignalType.ONE);

        assertTrue(signalService instanceof FirstSignalService);
    }

    @Test
    void should_not_create_incorrect_signal_service_for_received_signal_1() {
        SignalService signalService = SignalServiceFactory.getSignalService(SignalType.ONE);

        assertFalse(signalService instanceof SecondSignalService);
    }

    @Test
    void should_create_correct_signal_service_for_received_signal_2() {
        SignalService signalService = SignalServiceFactory.getSignalService(SignalType.TWO);

        assertTrue(signalService instanceof SecondSignalService);
    }

    @Test
    void should_not_create_incorrect_signal_service_for_received_signal_2() {
        SignalService signalService = SignalServiceFactory.getSignalService(SignalType.TWO);

        assertFalse(signalService instanceof FirstSignalService);
    }

    @Test
    void should_create_correct_signal_service_for_received_signal_3() {
        SignalService signalService = SignalServiceFactory.getSignalService(SignalType.THREE);

        assertTrue(signalService instanceof ThirdSignalService);
    }

    @Test
    void should_not_create_incorrect_signal_service_for_received_signal_3() {
        SignalService signalService = SignalServiceFactory.getSignalService(SignalType.THREE);

        assertFalse(signalService instanceof FirstSignalService);
    }

    @Test
    void should_create_correct_signal_service_for_received_signal_4() {
        SignalService signalService = SignalServiceFactory.getSignalService(SignalType.DEFAULT);

        assertTrue(signalService instanceof DefaultSignalService);
    }

    @Test
    void should_not_create_incorrect_signal_service_for_received_signal_4() {
        SignalService signalService = SignalServiceFactory.getSignalService(SignalType.DEFAULT);

        assertFalse(signalService instanceof FirstSignalService);
    }
}
