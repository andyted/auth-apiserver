package lab.fruit.authapiserver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
public class AuthRestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    Logger logger = LoggerFactory.getLogger(AuthRestController.class);

    @PostMapping("/greeting")
    public Greeting greeting(@RequestBody Payload payload) {
        logger.info(String.format(template, payload.getFullName()));
        //logger.info("Request "  + payload.length);
        return new Greeting(counter.incrementAndGet(),String.format(template, payload.getFullName()));
        //return ("" + payload.length);
    }
}
