package com.example.TodoManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TodoManager.entity.Importance;

public interface ImportanceRepository  extends JpaRepository<Importance,Integer> {

}
