package com.DB.trading.service;

import com.DB.algo.Algo;
import org.springframework.stereotype.Component;

@Component
public class DefaultSignalService implements SignalService {
    private static final SignalType SIGNAL_TYPE = SignalType.DEFAULT;

    private Algo algo;

    public DefaultSignalService(Algo algo) {
        this.algo = algo;
    }

    @Override
    public void doAlgo() {
        algo.cancelTrades();
        algo.doAlgo();
    }

    @Override
    public SignalType getType() {
        return SIGNAL_TYPE;
    }

}
