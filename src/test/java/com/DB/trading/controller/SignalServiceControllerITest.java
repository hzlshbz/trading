package com.DB.trading.controller;

import com.DB.trading.factory.SignalServiceFactory;
import com.DB.trading.configuration.TestConfig;
import com.DB.trading.service.FirstSignalService;
import com.DB.trading.service.SignalType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
@AutoConfigureMockMvc
@ContextConfiguration(classes = TestConfig.class)
public class SignalServiceControllerITest {

    public static final int SIGNAL_ID = 1;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SignalServiceFactory signalServiceFactory;

    @MockBean
    private FirstSignalService firstSignalService;

    @Test
    void should_return_status_ok() throws Exception {
        try (MockedStatic<SignalServiceFactory> signalServiceFactoryMock = Mockito.mockStatic(
                SignalServiceFactory.class)
        ) {
            signalServiceFactoryMock.when(() -> SignalServiceFactory.getSignalService(SignalType.ONE))
                    .thenReturn(firstSignalService);

            mockMvc.perform(MockMvcRequestBuilders.post("/signals/1:operate"))
                    .andExpect(MockMvcResultMatchers.status().isOk());

        }
    }

    @Test
    void should_return_status_bad_request_when_signal_id_is_not_integer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/signals/string:operate"))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

}
