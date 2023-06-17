package com.DB.trading.service;

import com.DB.algo.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SecondSignalServiceTest {

    @Mock
    private Algo algo;
    private SecondSignalService secondSignalService;

    @BeforeEach
    void test() {
        secondSignalService = new SecondSignalService(algo);

    }

    @Test
    void should_invoke_algo_methods_when_doAlgo_is_called() {
        secondSignalService.doAlgo();

        verify(algo, Mockito.times(1)).reverse();
        verify(algo, Mockito.times(1)).setAlgoParam(1, 80);
        verify(algo, Mockito.times(1)).submitToMarket();
        verify(algo, Mockito.times(1)).doAlgo();
    }

    @Test
    void should_not_invoke_unnecessary_methods_when_doAlgo_is_called() {
        secondSignalService.doAlgo();

        verify(algo, Mockito.times(0)).setUp();
        verify(algo, Mockito.times(0)).setAlgoParam(1, 40);
        verify(algo, Mockito.times(0)).performCalc();
    }

    @Test
    void should_throw_exception_when_algo_is_null() {
        doThrow(NullPointerException.class).when(algo).doAlgo();

        assertThrows(
                NullPointerException.class,
                () -> secondSignalService.doAlgo()
        );
    }

}
