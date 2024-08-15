package com.example.testtaskmanagementsystem.controller;

import com.example.testtaskmanagementsystem.model.dto.TaskDTO;
import com.example.testtaskmanagementsystem.service.TaskManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskManagementController  {

    private final TaskManagementService taskManagementService;


    @PostMapping()
    public ResponseEntity<HttpStatus> createTask(@RequestBody TaskDTO taskDTO){
        taskManagementService.createTask(taskDTO);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDTO> getTask(@PathVariable Long taskId){
        TaskDTO task = taskManagementService.getTask(taskId);

        return new ResponseEntity<>(task, HttpStatus.OK);
    }
    @DeleteMapping("/{taskId}")
    public ResponseEntity<HttpStatus> deleteTask(@PathVariable Long taskId){
        taskManagementService.deleteTask(taskId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping ("/{taskId}")
    public ResponseEntity<HttpStatus> updateTask(@RequestBody TaskDTO taskDTO, @PathVariable Long taskId){

        taskManagementService.updateTask(taskDTO, taskId);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
