package com.jerilmj.initiator.quickfix;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import quickfix.*;

@Slf4j
@Component
public class QuickfixClientApplication implements Application {

    public static volatile SessionID sessionId;

    @Override
    public void onCreate(SessionID sessionID) {
        log.info("onLogon");
        QuickfixClientApplication.sessionId = sessionID;
    }

    @Override
    public void onLogon(SessionID sessionID) {

    }

    @Override
    public void onLogout(SessionID sessionID) {

    }

    @Override
    public void toAdmin(Message message, SessionID sessionID) {

    }

    @Override
    public void fromAdmin(
            Message message, SessionID sessionID
    ) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, RejectLogon {
        log.info("fromAdmin: " + message);
    }

    @Override
    public void toApp(Message message, SessionID sessionID) throws DoNotSend {

    }

    @Override
    public void fromApp(
            Message message, SessionID sessionID
    ) throws FieldNotFound, IncorrectDataFormat, IncorrectTagValue, UnsupportedMessageType {
        log.info("fromApp: " + message);
    }

}
