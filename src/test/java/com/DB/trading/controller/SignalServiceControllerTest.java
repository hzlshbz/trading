package com.DB.trading.controller;

import com.DB.trading.factory.SignalServiceFactory;
import com.DB.trading.service.DefaultSignalService;
import com.DB.trading.service.FirstSignalService;
import com.DB.trading.service.SecondSignalService;
import com.DB.trading.service.SignalType;
import com.DB.trading.service.ThirdSignalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SignalServiceControllerTest {

    public static final int SIGNAL_ID_1 = 1;
    public static final int SIGNAL_ID_3 = 3;
    public static final int SIGNAL_ID_2 = 2;
    public static final int SIGNAL_ID_0 = 0;

    @Mock
    private FirstSignalService firstSignalService;

    @Mock
    private SecondSignalService secondSignalService;

    @Mock
    private ThirdSignalService thirdSignalService;

    @Mock
    private DefaultSignalService defaultSignalService;

    private SignalController signalController;

    @BeforeEach
    void setUp() {
        signalController = new SignalController();

    }

    @Test
    void should_invoke_signal_service_correctly_for_one() {
        try (MockedStatic<SignalServiceFactory> signalServiceFactoryMock = Mockito.mockStatic(
                SignalServiceFactory.class)
        ) {
            signalServiceFactoryMock.when(() -> SignalServiceFactory.getSignalService(SignalType.ONE))
                    .thenReturn(firstSignalService);

            signalController.signal(SIGNAL_ID_1);

            verify(firstSignalService).doAlgo();

        }
    }

    @Test
    void should_invoke_signal_service_correctly_for_two() {
        try (MockedStatic<SignalServiceFactory> signalServiceFactoryMock = Mockito.mockStatic(
                SignalServiceFactory.class)
        ) {
            signalServiceFactoryMock.when(() -> SignalServiceFactory.getSignalService(SignalType.TWO))
                    .thenReturn(secondSignalService);

            signalController.signal(SIGNAL_ID_2);

            verify(secondSignalService).doAlgo();

        }
    }

    @Test
    void should_invoke_signal_service_correctly_for_three() {
        try (MockedStatic<SignalServiceFactory> signalServiceFactoryMock = Mockito.mockStatic(
                SignalServiceFactory.class)
        ) {
            signalServiceFactoryMock.when(() -> SignalServiceFactory.getSignalService(SignalType.THREE))
                    .thenReturn(thirdSignalService);

            signalController.signal(SIGNAL_ID_3);

            verify(thirdSignalService).doAlgo();

        }
    }

    @Test
    void should_invoke_signal_service_correctly_for_default() {
        try (MockedStatic<SignalServiceFactory> signalServiceFactoryMock = Mockito.mockStatic(
                SignalServiceFactory.class)
        ) {
            signalServiceFactoryMock.when(() -> SignalServiceFactory.getSignalService(SignalType.DEFAULT))
                    .thenReturn(defaultSignalService);

            signalController.signal(SIGNAL_ID_0);

            verify(defaultSignalService).doAlgo();

        }
    }

    @Test
    void should_throw_exception_when_exception_thrown() {
        try (MockedStatic<SignalServiceFactory> signalServiceFactoryMock = Mockito.mockStatic(
                SignalServiceFactory.class)
        ) {
            signalServiceFactoryMock.when(() -> SignalServiceFactory.getSignalService(SignalType.DEFAULT))
                    .thenThrow(NullPointerException.class);

            assertThrows(
                    NullPointerException.class,
                    () -> signalController.signal(SIGNAL_ID_0)
            );
        }
    }

}
