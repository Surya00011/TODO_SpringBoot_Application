package com.todolist.ToDo.Application.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.ToDo.Application.Entity.ToDoEntity;
import com.todolist.ToDo.Application.HandleException.TaskNotFoundException;
import com.todolist.ToDo.Application.Repository.ToDoRepository;

//Service layer logics to interact with database
@Service
public class ToDoService {
   
	@Autowired
	ToDoRepository todoRepo;
	
	//method that collects data from controllerLayer and saves it to Database
	public ToDoEntity collectTaskFromControllerAndSavetoDB(ToDoEntity task) {
		
		ToDoEntity savedTask = todoRepo.save(task);

	    return savedTask;
	}
	
	//method to get list of all tasks
	public List<ToDoEntity> getTaskList() {
		List<ToDoEntity> output = todoRepo.findAll();
		
		return output;
		
	}
	
	//method to get task by id
	public ToDoEntity getTaskById(int taskid) {
		 return todoRepo.findById(taskid).orElseThrow(() -> new TaskNotFoundException("Task with ID " + taskid + " not found"));
	}
	
	//method to delete task
	public boolean deleteTaskById(int taskId) {
	    // Assuming there is a repository or DAO layer for task handling
	    Optional<ToDoEntity> taskOptional = todoRepo.findById(taskId);
	    if (taskOptional.isPresent()) {
	        todoRepo.delete(taskOptional.get());  // Delete the task
	        return true;
	    }
	    return false;  // Return false if the task with the given ID was not found
	}

}
