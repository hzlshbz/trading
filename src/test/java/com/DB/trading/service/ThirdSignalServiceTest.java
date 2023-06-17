package com.DB.trading.service;

import com.DB.algo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ThirdSignalServiceTest {

    @Mock
    private Algo algo;
    private ThirdSignalService thirdSignalService;

    @BeforeEach
    void test() {
        thirdSignalService = new ThirdSignalService(algo);

    }

    @Test
    void should_invoke_algo_methods_when_doAlgo_is_called() {
        thirdSignalService.doAlgo();

        verify(algo, Mockito.times(2)).setAlgoParam(anyInt(),anyInt());
        verify(algo, Mockito.times(1)).performCalc();
        verify(algo, Mockito.times(1)).submitToMarket();
        verify(algo, Mockito.times(1)).doAlgo();
    }

    @Test
    void should_not_invoke_unnecessary_methods_when_doAlgo_is_called() {
        thirdSignalService.doAlgo();

        verify(algo, Mockito.times(0)).setUp();
        verify(algo, Mockito.times(0)).reverse();
    }

    @Test
    void should_throw_exception_when_algo_is_null() {
        doThrow(NullPointerException.class).when(algo).doAlgo();

        assertThrows(
                NullPointerException.class,
                () -> thirdSignalService.doAlgo()
        );
    }

}
