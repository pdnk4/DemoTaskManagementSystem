package com.example.testtaskmanagementsystem.model.dto;


import com.example.testtaskmanagementsystem.model.enums.Priority;
import com.example.testtaskmanagementsystem.model.enums.Status;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TaskDTO {

    private Long id;
    private String title;
    private String description;
    private Priority priority;
    private Status status;
    private String authorUsername;
    private String executorUsername;
}
