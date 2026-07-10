package com.spring.SpringbootPractice.Controller;

import com.spring.SpringbootPractice.service.LogTestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/v1/logs")
public class logsController {

    @Autowired
    LogTestService logTestService;

    @GetMapping("/check")
    public ResponseEntity<?> getTestingLogs(@RequestHeader(required = true) String authorization) throws InterruptedException {
        log.info("Authorization header: {}", authorization);
        logTestService.serve();
        return ResponseEntity.ok("Logs are working fine");
    }
}
