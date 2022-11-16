package com.requestcounter.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class CounterService {

    private final RedisTemplate redisTemplate;

    private final AtomicInteger counter = new AtomicInteger();


    public String getCounterRedis(String name) {
        RedisAtomicInteger counterRedis =
                new RedisAtomicInteger("counter-redis", redisTemplate.getConnectionFactory());
        return "\"" + "Hello, " + name + ", " + counterRedis.incrementAndGet() + "\"";
    }

    public String getCounter(String name) {
        return "\"" + "Hello, " + name + ", " + counter.incrementAndGet() + "\"";
    }
}
