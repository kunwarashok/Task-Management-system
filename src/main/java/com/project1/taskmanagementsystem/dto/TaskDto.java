package com.project1.taskmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private String priority;
    private String status;
}
