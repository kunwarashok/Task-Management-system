package com.project1.taskmanagementsystem.service;

import com.project1.taskmanagementsystem.dto.TaskDto;
import com.project1.taskmanagementsystem.model.Task;
import com.project1.taskmanagementsystem.model.User;

import com.project1.taskmanagementsystem.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public Task createTask(TaskDto taskDto) {
        Task task=new Task();
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());
        task.setPriority(taskDto.getPriority());
        task.setStatus(taskDto.getStatus());
        return taskRepository.save(task);

    }

    public Task updateTask(Long taskId, TaskDto taskDto) {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with ID: " + taskId));
        existingTask.setTitle(taskDto.getTitle());
        existingTask.setDescription(taskDto.getDescription());
        existingTask.setDueDate(taskDto.getDueDate());
        existingTask.setPriority(taskDto.getPriority());
        existingTask.setStatus(taskDto.getStatus());
        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);

    }

    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Task not found with ID: " + taskId));
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksBYStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    public List<Task> getTasksByPriority(String priority) {
        return taskRepository.findByPriority(priority);
    }

    public List<Task> getTasksByDueDate(Date dueDate) {
        return taskRepository.findByDueDate(dueDate);
    }
}
