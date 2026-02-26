package com.order.order.controller;

import com.order.order.model.Task;
import com.order.order.service.TaskService;
import com.order.order.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("task")
public class TaskController {

    @Autowired
    private TaskService taskService;



    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping("/next")
    public Task getTask(){
        return taskService.getNextTask();

    }

    @GetMapping("/all")
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping("{Id}/complete")
    public Task completeTask(@PathVariable("Id") String taskId){
        return taskService.completeTask(taskId);
    }

    @PostMapping("{Id}")
    public void deleteTask(@RequestBody Task task){
         taskService.deleteTask(task);
    }

}
