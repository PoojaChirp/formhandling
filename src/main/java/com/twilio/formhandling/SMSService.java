package com.twilio.formhandling;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.twilio.Twilio;
import com.twilio.formhandling.domain.SMS;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SMSService {

    @Value("${ACCOUNT_SID}")
    private String ACCOUNT_SID;

    @Value("${AUTH_TOKEN}")
    private String AUTH_TOKEN;

    @Value("${FROM_NUMBER}")
    private String FROM_NUMBER;

    public void send(SMS sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        // to number, from: always twilio snd a message
        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage()).create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction
    }
}
