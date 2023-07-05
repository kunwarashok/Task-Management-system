package com.project1.taskmanagementsystem.controller;

import com.project1.taskmanagementsystem.dto.TaskDto;
import com.project1.taskmanagementsystem.model.Task;
import com.project1.taskmanagementsystem.service.TaskService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
   private final TaskService taskService;

   @PostMapping
   public ResponseEntity<Task> createTask(@RequestBody TaskDto taskDto){
     Task createdTask=taskService.createTask(taskDto);
     return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
   }
@PutMapping("/{taskId}")
   public ResponseEntity<Task> updateTask(@PathVariable Long taskId,@RequestBody TaskDto taskDto){
      Task updatedTask=taskService.updateTask(taskId,taskDto);
      return new ResponseEntity<>(updatedTask,HttpStatus.OK);
}
@DeleteMapping("/{taskId}")
   public ResponseEntity<Task> deleteTask(@PathVariable Long taskId){
      taskService.deleteTask(taskId);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@GetMapping("/{taskId}")
   public ResponseEntity<Task> getTaskById(@PathVariable Long taskId){
      Task task=taskService.getTaskById(taskId);
      return new ResponseEntity<>(task,HttpStatus.OK);
}
@GetMapping
   public ResponseEntity<List<Task>> getAllTasks(){
      List<Task> tasks=taskService.getAllTasks();
      return new ResponseEntity<>(tasks,HttpStatus.OK);
}
@GetMapping("/status/{status}")
   public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status){
      List<Task> tasks=taskService.getTasksBYStatus(status);
      return new ResponseEntity<>(tasks, HttpStatus.OK);
}
@GetMapping("/priority/{priority}")
   public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable String priority){
      List<Task> tasks=taskService.getTasksByPriority(priority);
      return new ResponseEntity<>(tasks,HttpStatus.OK);
}
@GetMapping("/due-date/{dueDate}")
   public ResponseEntity<List<Task>> getTasksByDueDate(@PathVariable Date dueDate ){
     List<Task> tasks=taskService.getTasksByDueDate(dueDate);
     return new ResponseEntity<>(tasks,HttpStatus.OK);
}
}
