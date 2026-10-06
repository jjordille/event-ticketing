package com.eventticketing.health;

import java.time.Instant;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simplest possible endpoint. The frontend calls it to prove the
 * React -> Spring Boot connection works.
 */
@RestController
@RequestMapping("/api/ping")
public class PingController {

    @GetMapping
    public PingResponse ping() {
        return new PingResponse("pong", Instant.now());
    }

    public record PingResponse(String message, Instant timestamp) {
    }
}
