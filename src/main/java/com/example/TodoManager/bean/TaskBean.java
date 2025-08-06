package com.example.TodoManager.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * TaskクラスのBean
 */
public class TaskBean {

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
		private LocalDate Date;
		
		/**
		 * 完了期限時間
		 */
		@NotNull
		private LocalTime deadlineTime;
		
		/**
		 * 完了期限日時
		 * HACK:日付と時間を別々に取得するならこのフィールドとgetter,setterは不要
		 */
		@NotNull
		private LocalDateTime deadlineDate;
		
		/**
		 * 作成日
		 */
		@NotNull
		private Date createDate;
		
		/**
		 * 削除フラグ
		 */
		@NotNull
		private Boolean deleteFlag;
		
		/**
		 * 完了フラグ
		 */
		@NotNull
		private Boolean completeFlag;
		
		/**
		 * アーカイブフラグ
		 */
		@NotNull
		private Boolean archiveFlag;
		
		/**
		 * 重要度
		 */
		@NotNull
		private Integer importanceId;
		
		/**
		 * ユーザID
		 */
		@NotNull
		private Integer personalId;
		
		
		/**
		 * タスクIDの取得
		 * @return
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
		 * @return
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
		 * @return
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
		 * @return
		 */
		public LocalDate getDate() {
			return Date;
		}

		/**
		 * 完了期限日付のセット
		 * @param date
		 */
		public void setDate(LocalDate date) {
			Date = date;
		}

		/**
		 * 完了期限日時の取得
		 * @return
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
		 * 完了期限時間の取得
		 * @return
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
		 * 作成日の取得
		 * @return
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
		 * @return
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
		 * @return
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

	
}
