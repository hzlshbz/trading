package com.DB.trading.service;

import com.DB.algo.Algo;
import org.springframework.stereotype.Component;

@Component
public class SecondSignalService implements SignalService {
    private static final SignalType SIGNAL_TYPE = SignalType.TWO;

    private Algo algo;

    public SecondSignalService(Algo algo) {
        this.algo = algo;
    }

    @Override
    public void doAlgo() {
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
        algo.doAlgo();
    }

    @Override
    public SignalType getType() {
        return SIGNAL_TYPE;
    }

}
