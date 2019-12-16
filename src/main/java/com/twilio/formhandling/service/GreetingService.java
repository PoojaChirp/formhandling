package com.twilio.formhandling.service;

import com.twilio.formhandling.model.Greeting;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class GreetingService {
    public void save(Greeting greeting) throws IOException {

        FileWriter fw = new FileWriter("greetings.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(greeting.toString());
        bw.newLine();
        bw.close();

    }
}
