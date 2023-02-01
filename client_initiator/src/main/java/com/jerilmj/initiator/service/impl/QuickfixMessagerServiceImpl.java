package com.jerilmj.initiator.service.impl;

import com.jerilmj.initiator.quickfix.QuickfixClientApplication;
import com.jerilmj.initiator.service.QuickfixMessagerService;
import org.springframework.stereotype.Service;
import quickfix.Session;
import quickfix.SessionNotFound;
import quickfix.field.*;
import quickfix.fix44.Quote;

import java.time.LocalDateTime;

@Service
public class QuickfixMessagerServiceImpl implements QuickfixMessagerService {

    @Override
    public void sendQuoteToServer() throws SessionNotFound {
        Quote quote = new Quote(new QuoteID("qt"));
        quote.setField(new OnBehalfOfSubID("ACC"));
        quote.setField(new quickfix.field.Account("ACC"));
        quote.setField(new OrdType(OrdType.LIMIT));
        quote.setField(new OfferPx(0));
        quote.setField(new OfferSize(0));
        quote.setField(new PriceType(PriceType.PERCENTAGE));
        quote.setField(new QuoteType(QuoteType.TRADEABLE));
        quote.setField(new SecurityID("ABC123XYZ"));
        quote.setField(new Symbol("ABC123XYZ"));
        quote.setField(new TransactTime(LocalDateTime.now()));
        quote.setField(new QuoteResponseLevel(QuoteResponseLevel.ACKNOWLEDGE_ONLY_NEGATIVE_OR_ERRONEOUS_QUOTES));

        Session.sendToTarget(quote, QuickfixClientApplication.sessionId);
    }

}
