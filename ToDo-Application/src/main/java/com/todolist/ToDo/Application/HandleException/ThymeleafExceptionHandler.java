package com.todolist.ToDo.Application.HandleException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//Gives error page as response
@ControllerAdvice
public class ThymeleafExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public String handleTaskNotFoundException(TaskNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "errorPage"; // This maps to the errorPage.html template
    }
}
