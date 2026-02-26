package com.order.order.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.order.order.model.Task;
public interface TaskRepository extends JpaRepository<Task, Long>{
}
