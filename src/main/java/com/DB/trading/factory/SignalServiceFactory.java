package com.DB.trading.factory;

import com.DB.trading.service.SignalService;
import com.DB.trading.service.SignalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class SignalServiceFactory {

    private static Map<SignalType, SignalService> signalMap;

    @Autowired
    private SignalServiceFactory(List<SignalService> signalServices) {
        signalMap = signalServices.stream()
                .collect(Collectors.toUnmodifiableMap(SignalService::getType, Function.identity()));
    }

    public static SignalService getSignalService(SignalType signalType) {
        return Optional.ofNullable(signalMap.get(signalType)).orElseThrow(IllegalArgumentException::new);
    }
}
