package com.example.demo.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogService {
    private final LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    public void addLog(String content) {
        Log log = new Log(content);
        logRepository.save(log);
    }

    public List<Log> getLogs() {
        return logRepository.findAll();
    }
}
