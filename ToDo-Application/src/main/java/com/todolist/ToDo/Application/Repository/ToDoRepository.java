package com.todolist.ToDo.Application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todolist.ToDo.Application.Entity.ToDoEntity;

//Repository layer provides methods to interact with database
@Repository
public interface ToDoRepository extends JpaRepository<ToDoEntity, Integer>{

}
