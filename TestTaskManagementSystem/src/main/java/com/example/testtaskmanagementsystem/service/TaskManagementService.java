package com.example.testtaskmanagementsystem.service;

import com.example.testtaskmanagementsystem.erorr.TaskNotFoundException;
import com.example.testtaskmanagementsystem.model.dto.TaskDTO;
import com.example.testtaskmanagementsystem.model.entity.TaskEntity;
import com.example.testtaskmanagementsystem.model.entity.UserEntity;
import com.example.testtaskmanagementsystem.repository.TaskRepository;
import com.example.testtaskmanagementsystem.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskManagementService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public void createTask(TaskDTO taskDTO) {
        UserEntity author = userRepository.findByUsername(taskDTO.getAuthorUsername());
        UserEntity executor = userRepository.findByUsername(taskDTO.getExecutorUsername());


        TaskEntity task = TaskEntity.builder()
                .title(taskDTO.getTitle())
                .description(taskDTO.getDescription())
                .priority(taskDTO.getPriority())
                .status(taskDTO.getStatus())
                .author(author)
                .executor(executor)
                .build();

        taskRepository.save(task);
    }


    public TaskDTO getTask(Long taskId) {
        TaskEntity taskReferenceById = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        return TaskDTO.builder()
                .id(taskReferenceById.getId())
                .title(taskReferenceById.getTitle())
                .description(taskReferenceById.getDescription())
                .status(taskReferenceById.getStatus())
                .priority(taskReferenceById.getPriority())
                .authorUsername(taskReferenceById.getAuthor().getUsername())
                .executorUsername(taskReferenceById.getExecutor().getUsername())
                .build();
    }

    public void updateTask(TaskDTO taskDTO, Long taskId) {
        TaskEntity task = taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task not found"));
        task.setDescription(taskDTO.getDescription() == null ? task.getDescription(): taskDTO.getDescription());
        task.setPriority(taskDTO.getPriority() == null ? task.getPriority() : taskDTO.getPriority());
        task.setTitle(taskDTO.getTitle() == null ? task.getTitle() : taskDTO.getTitle());
        task.setStatus(taskDTO.getStatus() == null ? task.getStatus() : taskDTO.getStatus());
        UserEntity executor = userRepository.findByUsername(taskDTO.getExecutorUsername());
        task.setExecutor(executor != null && !task.getExecutor().equals(executor) ? executor : task.getExecutor() );
        UserEntity author = userRepository.findByUsername(taskDTO.getExecutorUsername());
        task.setAuthor(author != null && !task.getAuthor().equals(author) ? author : task.getAuthor() );

        taskRepository.save(task);

    }

    public void deleteTask(Long taskId) {

        taskRepository.deleteById(taskId);
    }



//    String title = taskDTO.getTitle() == null ? "default" : taskDTO.getTitle();
}
