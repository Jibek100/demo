package com.example.demo.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class LogController {
    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping("/addlog")
    public String addLog(@RequestParam("content") String content) {
        try {
            logService.addLog(content);
            return "Log has been added successfuly!";
        } catch (Exception e) {
            return "Log was not added";
        }
    }
    
    @PostMapping("/logs")
    public List<Log> getLogs() {
        return logService.getLogs();
    }
}
