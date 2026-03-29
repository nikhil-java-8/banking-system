package com.nikhil.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.nikhil.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
}