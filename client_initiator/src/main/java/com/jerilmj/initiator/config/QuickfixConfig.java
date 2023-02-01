package com.jerilmj.initiator.config;

import com.jerilmj.initiator.quickfix.QuickfixClientApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import quickfix.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Configuration
@Slf4j
public class QuickfixConfig {

    @Autowired
    private QuickfixClientApplication application;

    @Bean
    public ThreadedSocketInitiator threadedSocketInitiator() {
        ThreadedSocketInitiator threadedSocketInitiator = null;
        try {
            String fileName = "initiator.cfg";
            SessionSettings settings = new SessionSettings(new FileInputStream(fileName));
            MessageStoreFactory storeFactory = new FileStoreFactory(settings);
            LogFactory logFactory = new FileLogFactory(settings);
            MessageFactory messageFactory = new DefaultMessageFactory();
            threadedSocketInitiator = new ThreadedSocketInitiator(
                    application, storeFactory, settings, logFactory, messageFactory);
        } catch (ConfigError | FileNotFoundException configError) {
            configError.printStackTrace();
        }

        return threadedSocketInitiator;
    }

}
