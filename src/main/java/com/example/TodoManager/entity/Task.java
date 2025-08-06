package com.example.TodoManager.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_task")
    @SequenceGenerator(name = "seq_task", sequenceName = "seq_task", allocationSize = 1)
	private Integer taskId;
	
	@Column
	private String taskName;
	
	@Column
	private String taskContents;
	
	@Column
	private LocalDateTime deadlineDate;
	
	@Column
	private LocalDate createDate;
	
	@PrePersist
    public void setCreateDateAutomatically() {
        this.createDate = LocalDate.now();
    }
	
	@Column
	private Boolean deleteFlag;
	
	@Column
	private Boolean completeFlag;
	
	@Column
	private Boolean archiveFlag;
	
	@Column
	private Integer importanceId;
	
	@Column
	private Integer personalId;
	
	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskContents() {
		return taskContents;
	}

	public void setTaskContents(String taskContents) {
		this.taskContents = taskContents;
	}

	public LocalDateTime getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(LocalDateTime deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Boolean getCompleteFlag() {
		return completeFlag;
	}

	public void setCompleteFlag(Boolean completeFlag) {
		this.completeFlag = completeFlag;
	}

	public Boolean getArchiveFlag() {
		return archiveFlag;
	}

	public void setArchiveFlag(Boolean archiveFrag) {
		this.archiveFlag = archiveFrag;
	}

	public Integer getImportanceId() {
		return importanceId;
	}

	public void setImportanceId(Integer importanceId) {
		this.importanceId = importanceId;
	}

	public Integer getPersonalId() {
		return personalId;
	}

	public void setPersonalId(Integer personalId) {
		this.personalId = personalId;
	}

}	
