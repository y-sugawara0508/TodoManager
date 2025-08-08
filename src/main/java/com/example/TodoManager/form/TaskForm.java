package com.example.TodoManager.form;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * TaskクラスのForm
 */
public class TaskForm {

	/**
	 * タスクID
	 */
	private Integer taskId;

	/**
	 * タスク名
	 */
	@NotBlank
	@Size(max = 20)
	private String taskName;

	/**
	 * 詳細説明
	 */
	@NotBlank
	@Size(max = 500)
	private String taskContents;

	/**
	 * 完了期限日付
	 */
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	/**
	 * 完了期限時間
	 */
	@NotNull
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime deadlineTime;

	/**
	 * 完了期限日時
	 */
	private LocalDateTime deadlineDate;

	/**
	 * 作成日
	 */
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date createDate;

	/**
	 * 削除フラグ
	 */
	private Boolean deleteFlag;

	/**
	 * 完了フラグ
	 */
	private Boolean completeFlag;

	/**
	 * アーカイブフラグ
	 */
	private Boolean archiveFlag;

	/**
	 * 重要度
	 */
	private Integer importanceId;

	/**
	 * ユーザID
	 */
	private Integer personalId;

	/**
	 * タスクIDの取得
	 * @return taskId
	 */
	public Integer getTaskId() {
		return taskId;
	}

	/**
	 * タスクIDのセット
	 * @param taskId
	 */
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	/**
	 * タスク名の取得
	 * @return taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * タスク名のセット
	 * @param taskName
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * 詳細説明の取得
	 * @return taskContents
	 */
	public String getTaskContents() {
		return taskContents;
	}

	/**
	 * 詳細説明のセット
	 * @param taskContents
	 */
	public void setTaskContents(String taskContents) {
		this.taskContents = taskContents;
	}

	/**
	 * 完了期限日付の取得
	 * @return date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * 完了期限日付のセット
	 * @param date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * 完了期限時間の取得
	 * @return deadlineTime
	 */
	public LocalTime getDeadlineTime() {
		return deadlineTime;
	}

	/**
	 * 完了期限時間のセット
	 * @param deadlineTime
	 */
	public void setDeadlineTime(LocalTime deadlineTime) {
		this.deadlineTime = deadlineTime;
	}

	/**
	 * 完了期限日時の取得
	 * @return deadlineDate
	 */
	public LocalDateTime getDeadlineDate() {
		return deadlineDate;
	}

	/**
	 * 完了期限日時のセット
	 * @param deadlineDate
	 */
	public void setDeadlineDate(LocalDateTime deadlineDate) {
		this.deadlineDate = deadlineDate;
	}

	/**
	 * 作成日の取得
	 * @return CreateDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 作成日のセット
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 重要度の取得
	 * @return importanceId
	 */
	public Integer getImportanceId() {
		return importanceId;
	}

	/**
	 * 重要度のセット
	 * @param importanceId
	 */
	public void setImportanceId(Integer importanceId) {
		this.importanceId = importanceId;
	}

	/**
	 * ユーザIDの取得
	 * @return presonalId
	 */
	public Integer getPersonalId() {
		return personalId;
	}

	/**
	 * ユーザIDのセット
	 * @param personalId
	 */
	public void setPersonalId(Integer personalId) {
		this.personalId = personalId;
	}

	/**
	 * 削除フラグの取得
	 * @param deleteFlag
	 */
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 削除フラグのセット
	 * @param deleteFlag
	 */
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * 完了フラグの取得
	 * @param completeFlag
	 */
	public Boolean getCompleteFlag() {
		return completeFlag;
	}

	/**
	 * 完了フラグのセット
	 * @param completeFlag
	 */
	public void setCompleteFlag(Boolean completeFlag) {
		this.completeFlag = completeFlag;
	}

	/**
	 * アーカイブフラグの取得
	 * @param archiveFlag
	 */
	public Boolean getArchiveFlag() {
		return archiveFlag;
	}

	/**
	 * アーカイブフラグのセット
	 * @param archiveFlag
	 */
	public void setArchiveFlag(Boolean archiveFlag) {
		this.archiveFlag = archiveFlag;
	}
}
