package com.nikhil.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nikhil.entity.AuditLog;
import com.nikhil.repository.AuditLogRepository;

import java.time.LocalDateTime;

@Service
public class AuditService {

    @Autowired
    private AuditLogRepository auditRepo;

    public void log(String username, String action, Long accountId,
                    Double amount, String status, String description) {

      /*  AuditLog log = AuditLog.builder()
                .username(username)
                .action(action)
                .accountId(accountId)
                .amount(amount)
                .status(status)
                .description(description)
                .timestamp(LocalDateTime.now())
                .build();

        auditRepo.save(log);*/
    }
}