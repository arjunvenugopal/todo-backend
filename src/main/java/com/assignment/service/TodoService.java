package com.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.model.TodoItem;

@Service
public class TodoService {

	@Autowired
	TodoRepository repo;

	public boolean saveNewItem(TodoItem item) {
		try {
			repo.save(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public TodoItem getTodoItem(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<TodoItem> getAllItems() {
		return (List<TodoItem>) repo.findAll();
	}

	public boolean removeItem(int id) {
		try {
			repo.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateItem(TodoItem item) {
		try {
			TodoItem i = null;
			if (repo.existsById(item.getId())) {
				i = repo.findById(item.getId()).orElse(null);
			}
			if (i == null) {
				i = item;
			} else {
				i.setCompleted(item.isCompleted());
				i.setDetails(item.getDetails());
			}
			repo.save(i);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
