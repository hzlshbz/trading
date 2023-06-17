package com.DB.trading.service;

import org.springframework.stereotype.Service;

@Service
public interface SignalService {
    void doAlgo();
    SignalType getType();

}
