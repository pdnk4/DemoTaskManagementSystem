package com.example.testtaskmanagementsystem.model.entity;

import jakarta.persistence.*;

@Entity

public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    private UserEntity author;

    @ManyToOne
    private TaskEntity task;
}
