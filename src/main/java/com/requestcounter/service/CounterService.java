package com.requestcounter.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicInteger;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class CounterService {

    private static final String COUNTER_REDIS = "counter-redis";

    private final RedisTemplate<String, Integer> redisTemplate;

    private final AtomicInteger counter = new AtomicInteger();


    public String getCounterRedis(String name) {
        RedisConnectionFactory connectionFactory =
                Objects.requireNonNull(redisTemplate.getConnectionFactory());

        RedisAtomicInteger counterRedis = new RedisAtomicInteger(COUNTER_REDIS, connectionFactory);

        return "\"" + "Hello, " + name + ", " + counterRedis.incrementAndGet() + "\"";
    }

    public String getCounter(String name) {
        return "\"" + "Hello, " + name + ", " + counter.incrementAndGet() + "\"";
    }
}
