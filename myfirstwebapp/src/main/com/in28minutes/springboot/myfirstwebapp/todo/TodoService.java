package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
	private static int todosCount = 0;
	
	private static List<Todo> todos = new ArrayList<>();
	
	// adding static initial data
	static {
		todos.add(new Todo(++todosCount, "Paritosh Dadhich", "Learn Spring Boot", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "Paritosh Dadhich", "Learn DevOps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todosCount, "Paritosh Dadhich", "Learn Data Structures", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUserName(String userName) {
		return todos.stream().filter(todo->todo.getUserName().equals(userName)).toList();
	}
	
	public void addTodo(String userName, String description, LocalDate targetDate, boolean isDone) {
		todos.add(new Todo(++todosCount, userName, description, targetDate, isDone));
	}
	
	public void deleteTodoById(int id) {
		 todos.removeIf(todo -> todo.getId() == id);
	}
	
	public Todo findById(int id) {
		Todo todo = todos.stream().filter(t -> t.getId() == id).findFirst().get();
		return todo;
		
	}

	public void updateTodo(@Valid Todo todo) {
		deleteTodoById(todo.getId());
		todos.add(todo);
	}
	
}
