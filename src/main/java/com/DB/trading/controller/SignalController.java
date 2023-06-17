package com.DB.trading.controller;


import com.DB.trading.converter.SignalConverter;
import com.DB.trading.factory.SignalServiceFactory;
import com.DB.trading.service.SignalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignalController {

    @PostMapping(value = "/signals/{signalId}:operate")
    @ResponseStatus(value = HttpStatus.OK)
    public void signal(@PathVariable int signalId) {
        SignalService signalService = SignalServiceFactory.getSignalService(SignalConverter.getSignalType(signalId));
        signalService.doAlgo();
    }
}
