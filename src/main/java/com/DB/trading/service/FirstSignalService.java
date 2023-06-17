package com.DB.trading.service;

import com.DB.algo.Algo;
import org.springframework.stereotype.Component;

@Component
public class FirstSignalService implements SignalService {
    private static final SignalType SIGNAL_TYPE = SignalType.ONE;

    private Algo algo;

    public FirstSignalService(Algo algo) {
        this.algo = algo;
    }

    @Override
    public void doAlgo() {
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }

    @Override
    public SignalType getType() {
        return SIGNAL_TYPE;
    }


}
