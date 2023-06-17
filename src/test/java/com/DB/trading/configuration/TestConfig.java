package com.DB.trading.configuration;

import com.DB.algo.Algo;
import com.DB.trading.service.SignalService;
import com.DB.trading.service.SignalType;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@TestConfiguration
public class TestConfig {

    @Bean
    public Algo algoBean() {
        return new Algo();
    }

}
