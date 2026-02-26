package com.order.order.service.impl;

import com.order.order.service.TaskService;
import com.order.order.model.Task;
import org.springframework.stereotype.Service;
import java.util.*;
import com.order.order.repository.TaskRepository;



@Service
public class TaskServiceImpl implements TaskService {

    private final PriorityQueue<Task> taskQueue;
    private final Map<String, Task> taskStore = new HashMap<>();

    public TaskServiceImpl() {
        this.taskQueue = new PriorityQueue<>((t1, t2) -> {

            if(t1.getPriority().value != t2.getPriority().value)
            {
                return t2.getPriority().value - t1.getPriority().value;
            }
            return t1.getDeadLine().compareTo(t2.getDeadLine());

        });
    }
    @Override
    public Task addTask(Task task) {

            taskQueue.add(task);
            taskStore.put(task.getId(), task);
            return task;

    }

    @Override
    public Task getNextTask() {
        return taskQueue.peek();
    }

    @Override
    public void deleteTask(Task task) {
        taskQueue.remove(task);
        taskStore.remove(task.getId());
    }

    @Override
    public List<Task> getTasks() {
        return new ArrayList<>(taskStore.values());
    }

    @Override
    public Task completeTask(String taskId) {
        Task task = taskStore.get(taskId);
        if(task == null)
            return null;

        task.setStatus(Task.Status.COMPLETED);
        taskQueue.remove(task);
        taskStore.put(taskId, task);
        return task;
    }
}
