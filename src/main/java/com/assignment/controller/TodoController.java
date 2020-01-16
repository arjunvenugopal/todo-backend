package com.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.model.TodoItem;
import com.assignment.service.TodoService;

@RestController 
@RequestMapping("/controller")
public class TodoController {
	
	@Autowired
	TodoService service; 
	
	
	@RequestMapping(path="/additem", method=RequestMethod.POST)
	public boolean additem(@RequestBody TodoItem todoitem) {
		return service.saveNewItem(todoitem);
	}
	
	@RequestMapping(path="/getitem", method=RequestMethod.GET)
	public TodoItem getItem(@RequestParam("id") int id)
	{
		return service.getTodoItem(id);
	}
	
	@RequestMapping(path="/getallitems", method=RequestMethod.POST)
	public List<TodoItem> getallitems() {
		return service.getAllItems();
	}
	
	@RequestMapping(path="/removeitem", method=RequestMethod.POST)
	public boolean removeitem(@RequestBody TodoItem todoitem) {
		return service.removeItem(todoitem.getId());
	}
	
	@RequestMapping(path="/updateitem", method=RequestMethod.POST)
	public boolean updateitem (@RequestBody TodoItem todoitem) {
		return service.updateItem(todoitem);		
	}
}
