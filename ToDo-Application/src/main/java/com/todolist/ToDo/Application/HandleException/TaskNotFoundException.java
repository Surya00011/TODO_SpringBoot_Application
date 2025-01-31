package com.todolist.ToDo.Application.HandleException;

//custom exception class to throw if user enters id that not existing in DB
public class TaskNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaskNotFoundException(String message) {
        super(message);
    }
}