package com.jerilmj.initiator.controller;

import com.jerilmj.initiator.service.QuickfixMessagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import quickfix.SessionNotFound;

@Controller
public class ClientMessageController {

    @Autowired
    private QuickfixMessagerService messagerService;

    @GetMapping(path = "/fix/send-msg")
    public ResponseEntity<?> sendMessage() {
        try {
            messagerService.sendQuoteToServer();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (SessionNotFound e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
