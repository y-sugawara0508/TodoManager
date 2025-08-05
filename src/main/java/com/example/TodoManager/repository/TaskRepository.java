package com.example.TodoManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TodoManager.entity.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
	
	List<Task> findAllByOrderByCreateDateDesc();
	List<Task> findByTaskNameContaining(String TaskName);

	/*	
		@Query ("SELECT t FROM Task t ORDER BY t.deadlineDate = :deadlineDate DESC")
		List<Task>findbyDeadlineDateQueryDesc(@Param("deadlineDate")Date deadlineDate);
		
		
		@Query ("SELECT t FROM Task t ORDER BY t.deadlineDate = :deadlineDate ASC")
		List<Task>findbyDeadlineDateQueryAsc(@Param("deadlineDate")Date deadlineDate);
		 
		@Query ("SELECT t FROM Task t ORDER BY t.importanceId = :importanceId DESC")
		List<Task>findbyImportanceIdQueryDesc(@Param("importanceId")Importance importanceId);
		 
		@Query ("SELECT t FROM Task t ORDER BY t.importanceId = :importanceId ASC")
		List<Task>findbyImportanceIdQueryAsc(@Param("importanceId")Importance importanceId);
		 
		@Query ("SELECT t FROM Task t ORDER BY t.completeFlag = :completeFlag DESC")
		List<Task>findbyCompleteFlagQueryDesc(@Param("completeFlag")boolean completeFlag);
		 
		@Query ("SELECT t FROM Task t ORDER BY t.completeFlag = :completeFlag ASC")
		List<Task>findbyCompleteFlagQueryAsc(@Param("completeFlag")boolean completeFlag);
	*/	
}

