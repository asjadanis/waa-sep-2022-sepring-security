package com.springaop.assignment4.repository;

import com.springaop.assignment4.aspects.ExecutionTime;
import com.springaop.assignment4.models.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Integer> {
}
