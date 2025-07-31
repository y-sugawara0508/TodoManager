package com.example.TodoManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TodoManager.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {

}
