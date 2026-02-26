package com.order.order.service;

import com.order.order.model.Task;
import java.util.List;

public interface TaskService
{
    Task addTask(Task task);
    Task getNextTask();
    void deleteTask(Task task);
    List<Task> getTasks();
    Task completeTask(String taskId);
}
