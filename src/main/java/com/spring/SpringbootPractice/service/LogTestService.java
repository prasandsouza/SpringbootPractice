package com.spring.SpringbootPractice.service;

import com.spring.SpringbootPractice.Annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

@Service
public class LogTestService {

    @LogExecutionTime
    public void serve() throws InterruptedException {
        Thread.sleep(2000);
    }
}
