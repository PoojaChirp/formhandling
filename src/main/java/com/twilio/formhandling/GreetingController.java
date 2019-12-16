package com.twilio.formhandling;

import com.twilio.formhandling.model.Greeting;
import com.twilio.formhandling.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class GreetingController {

    @Autowired
    GreetingService service;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Greeting greeting) {

        try {
            service.save(greeting);
        } catch (IOException e) {
          return  "error";
        }
        return "result";
    }

}