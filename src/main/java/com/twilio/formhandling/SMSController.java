package com.twilio.formhandling;

import com.twilio.formhandling.domain.SMS;
import com.twilio.formhandling.domain.SMSCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/smscallback", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String smsCallback(@RequestBody MultiValueMap<String, String> map) {
       service.receive(map);

        return "smscallbackresult";
    }

}