package com.example.TodoManager.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;

public class TaskBean {

	private Integer taskId;

	private String taskName;

	private String taskContents;

	private LocalDateTime deadlineDate;

	private LocalDate createDate;

	private Boolean deleteFlag;

	private Boolean completeFlag;

	private Boolean archiveFlag;

	private Integer importanceId;

	private Integer personalId;

	private Integer displayNo;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * 完了期限日付
	 */
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Date;

	/**
	 * 完了期限時間
	 */
	@NotNull
	private LocalTime deadlineTime;

	public LocalDate getDate() {
		return Date;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

	public LocalTime getDeadlineTime() {
		return deadlineTime;
	}

	public void setDeadlineTime(LocalTime deadlineTime) {
		this.deadlineTime = deadlineTime;
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

	public void setDeadlineDate(LocalDateTime localDateTime) {
		this.deadlineDate = localDateTime;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate localDate) {
		this.createDate = localDate;
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

	public void setArchiveFlag(Boolean archiveFlag) {
		this.archiveFlag = archiveFlag;
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

	public Integer getDisplayNo() {
		return displayNo;
	}

	public void setDisplayNo(Integer displayNo) {
		this.displayNo = displayNo;
	}

}
