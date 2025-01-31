package com.todolist.ToDo.Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.todolist.ToDo.Application.Entity.ToDoEntity;
import com.todolist.ToDo.Application.HandleException.TaskNotFoundException;
import com.todolist.ToDo.Application.Service.ToDoService;

import jakarta.validation.Valid;

//controller layer
@Controller
@RequestMapping("/todo")
public class ToDoController {
    
    @Autowired
    ToDoService service;
    
    // API to add new task 
    @PostMapping("/addtask")
    public String createTask(@Valid ToDoEntity task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("task", task); 
            return "addTask"; 
        }

        // If there are no errors,save the task
        ToDoEntity savedTask = service.collectTaskFromControllerAndSavetoDB(task);
        if (savedTask != null) {
            model.addAttribute("message", "Task added successfully!");
        } else {
            model.addAttribute("message", "Failed to add task.");
        }
        
        return "redirect:/todo/gettaskList"; // Redirect to task list after adding
    }

    // API to get list of saved tasks
    @GetMapping("/gettaskList")
    public String viewTask(Model m) {
        Object out = service.getTaskList();
        m.addAttribute("data", out);
        return "todoList"; 
    }
    // API to get task by id form
    @GetMapping("/gettaskby")
    public String showTaskForm() {
        // Ensure the correct template is being rendered
        return "taskForm"; // This should return taskForm.html
    }
    // API to get task by id
    @GetMapping("/gettaskbyid")
    public String getTask(@RequestParam("id") int taskId, Model model) {
        ToDoEntity out = service.getTaskById(taskId);
        if (out == null) {
            throw new TaskNotFoundException("Task with ID " + taskId + " not found.");
        }
        model.addAttribute("SingleData", out);
        return "todoTaskbyId";
    }
    //API to delete task
    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") int taskId, Model model) {
        boolean isDeleted = service.deleteTaskById(taskId);
        if (isDeleted) {
            model.addAttribute("message", "Task deleted successfully.");
        } else {
            model.addAttribute("message", "Failed to delete task.");
        }
        return "redirect:/todo/gettaskList"; // Redirect back to the task list after deletion
    }

    // API to show add task form
    @GetMapping("/addtaskform")
    public String showAddTaskForm(Model model) {
        model.addAttribute("task", new ToDoEntity()); 
        return "addTask"; 
    }
}
