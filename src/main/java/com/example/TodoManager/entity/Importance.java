package com.example.TodoManager.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "importance")
public class Importance {
	
	@Id
	private Integer importanceId;

	@Column
	private String importanceName;
	
	public Integer getImportanceId() {
		return importanceId;
	}

	public void setImportanceId(Integer importanceId) {
		this.importanceId = importanceId;
	}

	public String getImportanceName() {
		return importanceName;
	}

	public void setImportanceName(String importanceName) {
		this.importanceName = importanceName;
	}

}
