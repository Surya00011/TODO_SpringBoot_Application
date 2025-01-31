package com.todolist.ToDo.Application.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//Entity layer
@Entity
@Table(name="Todos")
public class ToDoEntity {
    
	@Id
	@NotNull
	private int taskId;
	
	@NotBlank(message="TaskName cannot be empty")
	private String taskName;
	
	@NotBlank(message="Task must have it's description")
	private String taskDescription;
	
	public ToDoEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ToDoEntity(int taskId, String taskName, String taskDescription) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	
}
