package com.example.TodoManager.bean;

import java.util.Date;

public class TaskBean {

	private Integer taskId;
	
	private String taskName;
	
	private String taskContents;
	
	private Date deadlineDate;
	
	private Date createDate;
	
	private Boolean deleteFlag;
	
	private Boolean completeFlag;
	
	private Boolean archiveFlag;
	
	private Integer importanceId;
	
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

	public Date getDeadlineDate() {
		return deadlineDate;
	}

	public void setDeadlineDate(Date deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
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
