package com.requestcounter.controller;

import com.requestcounter.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hello")
public class CounterController {

    private final CounterService counterService;

    @GetMapping("/{name}")
    public String getHello(@PathVariable("name") String name) {
        return counterService.getCounter(name);
    }
}
