package com.example.testtaskmanagementsystem.repository;


import com.example.testtaskmanagementsystem.model.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
}
