package com.DB.trading.service;

import com.DB.algo.Algo;
import org.springframework.stereotype.Component;

@Component
public class ThirdSignalService implements SignalService {
    private static final SignalType SIGNAL_TYPE = SignalType.THREE;
    private Algo algo;

    public ThirdSignalService(Algo algo) {
        this.algo = algo;
    }

    @Override
    public void doAlgo() {
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
    }

    @Override
    public SignalType getType() {
        return SIGNAL_TYPE;
    }

}
