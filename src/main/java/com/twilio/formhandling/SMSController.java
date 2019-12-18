package com.twilio.formhandling;

import com.twilio.formhandling.domain.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SMSController {

    @Autowired
    SMSService service;

    @GetMapping("/sms")
    public String smsForm(Model model) {
        SMS sms  = new SMS();
       /* sms.setMessage("Hey Buddy");
        sms.setTo("+13098264420");*/
        model.addAttribute("sms", sms);
        return "sms";
    }

    @PostMapping("/sms")
    public String smsSubmit(@ModelAttribute SMS sms, Model model) {
            service.send(sms);
        return "smsresult";
    }

    @PostMapping("/smscallback")
    public String smsCallback(@ModelAttribute SMS sms, Model model) {
        service.send(sms);
        return "smsresult";
    }

}