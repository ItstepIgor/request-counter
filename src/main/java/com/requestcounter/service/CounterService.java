package com.requestcounter.service;


import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CounterService {

    private final AtomicInteger counter = new AtomicInteger();

    public String getCounter(String name) {
        return "\"" + "Hello, " + name + ", " + counter.incrementAndGet() + "\"";
    }
}
