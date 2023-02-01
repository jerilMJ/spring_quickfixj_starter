package com.jerilmj.initiator.service;

import quickfix.SessionNotFound;

public interface QuickfixMessagerService {

    void sendQuoteToServer() throws SessionNotFound;

}
