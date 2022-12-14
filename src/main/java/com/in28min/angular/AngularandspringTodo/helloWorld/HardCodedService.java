package com.in28min.angular.AngularandspringTodo.helloWorld;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.springframework.stereotype.Service;
@Service
public class HardCodedService {
	private static List<Todos> todos = new ArrayList();
	private static int idCounter=0;
	
	static {
		todos.add(new Todos(++idCounter,"in28min","LearnToDance",new Date(),false));
		todos.add(new Todos(++idCounter,"in28min","LearnToCode",new Date(),false));
		todos.add(new Todos(++idCounter,"in28min","LearnToDrive",new Date(),false));
		
	}
	public List<Todos> findAll()
	{
		return todos;
	}
	
	public Todos deleteById(int id)
	{
		Todos todo = findById(id);
		if(todo==null) return null;
		if(todos.remove(todo))
		{
		return todo;
		}
		return null;
	}

	public Todos findById(int id) {
		for(Todos todo:todos)
		{
			if(todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
	
	public Todos save(Todos todo)
    {
		if(todo.getId()== -1 || todo.getId() ==0)
		{
			todo.setId(++idCounter);
			todos.add(todo);
		}
		else
		{
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}
	

}
