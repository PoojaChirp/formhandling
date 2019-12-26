package com.twilio.formhandling;

import com.twilio.formhandling.domain.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class SMSController {

    @Autowired
    SMSService service;

    @Autowired
    private SimpMessagingTemplate webSocket;

    @RequestMapping(value = "/sms", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsSubmit(@RequestBody SMS sms) {
        webSocket.convertAndSend("/topic/greetings", getTimeStamp() + ": Sending the SMS: "+sms.toString());
            service.send(sms);
        webSocket.convertAndSend("/topic/greetings", getTimeStamp() + ": SMS has been sent!: "+sms.toString());

    }

    @RequestMapping(value = "/smscallback", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void smsCallback(@RequestBody MultiValueMap<String, String> map) {
       service.receive(map);
       webSocket.convertAndSend("/topic/greetings", getTimeStamp() + ": Twilio has made a callback request! Here are the contents: "+map);
    }

    private String getTimeStamp() {
       return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}