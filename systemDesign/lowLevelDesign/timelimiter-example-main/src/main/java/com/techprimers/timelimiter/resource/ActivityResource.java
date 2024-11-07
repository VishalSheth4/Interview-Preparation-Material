package com.techprimers.timelimiter.resource;

import com.techprimers.timelimiter.model.Activity;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;
import java.util.random.RandomGenerator;

@Slf4j
@RestController
@RequestMapping("/activity")
public class ActivityResource {

    private RestTemplate restTemplate;

    public ActivityResource(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    @TimeLimiter(name = "activity")
    public CompletableFuture<String> getActivity() {
        return CompletableFuture.supplyAsync(this::slowMethod);
    }

    public String slowMethod() {

        if (RandomGenerator.getDefault().nextBoolean()) {
//        if (true) {
            log.error("Sleeping for 3 seconds");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Activity activity = restTemplate.getForObject("https://www.boredapi.com/api/activity", Activity.class);
        log.info("Received activity: ");
        return activity.getActivity();
    }

}
