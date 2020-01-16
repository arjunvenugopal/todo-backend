package com.assignment.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.model.TodoItem;;

@Repository
public interface TodoRepository extends CrudRepository<TodoItem, Integer> {
	
	
}
