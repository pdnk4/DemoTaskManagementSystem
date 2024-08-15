package com.example.testtaskmanagementsystem.model.entity;

import com.example.testtaskmanagementsystem.model.enums.Priority;
import com.example.testtaskmanagementsystem.model.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private Status status;
    @NotEmpty
    private String title;
    private String description;
    @ManyToOne
    private UserEntity author;
    @ManyToOne
    private UserEntity executor;
    @OneToMany
    private List<CommentEntity> comments;
}
