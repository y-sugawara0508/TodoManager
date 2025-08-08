
package com.example.TodoManager.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * 
 */
public class TaskBean {

	private Integer taskId;

	private String taskName;
	private String taskContents;

	private LocalDateTime deadlineDate;
	private LocalDateTime createDate;

	private Boolean deleteFlag;
	private Boolean completeFlag;
	private Boolean archiveFlag;

	private Integer importanceId;
	private Integer personalId;

	// Getter: 完了期限の「日付部分」だけ取得
	public LocalDate getDeadlineDateOnly() {
		return deadlineDate != null ? deadlineDate.toLocalDate() : null;
	}

	// Getter: 完了期限の「時間部分」だけ取得
	public LocalTime getDeadlineTimeOnly() {
		return deadlineDate != null ? deadlineDate.toLocalTime() : null;
	}

	// Getter: 作成日時の「日付部分」
	public LocalDate getCreateDateOnly() {
		return createDate != null ? createDate.toLocalDate() : null;
	}

	// Getter: 作成日時の「時間部分」
	public LocalTime getCreateTimeOnly() {
		return createDate != null ? createDate.toLocalTime() : null;
	}

	public String getCompleteFlagString() {
		return completeFlag ? "完了" : "未完了";
	}

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

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
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
}
