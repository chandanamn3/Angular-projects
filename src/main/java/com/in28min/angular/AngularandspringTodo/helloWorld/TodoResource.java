package com.in28min.angular.AngularandspringTodo.helloWorld;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoResource {
	@Autowired
	private HardCodedService services;
	@GetMapping("/users/{username}/todos")
	public List<Todos> getALLTodos(@PathVariable String username)
	{
		return services.findAll();
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todos getTodos(@PathVariable String username,@PathVariable int id)
	{
		return services.findById(id);
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,@PathVariable int id)
    {
		Todos todo = services.deleteById(id);
		if(todo!=null)
		{
			return ResponseEntity.noContent().build();
			
		}
		return ResponseEntity.notFound().build();
    }
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Todos> updateTodo(@RequestBody Todos todo,@PathVariable String username,@PathVariable int id)
    {
		Todos todoUpdated = services.save(todo);
		return new ResponseEntity<Todos>(todo,HttpStatus.OK);

    }
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<Void> addTodo(@RequestBody Todos todos,@PathVariable String username)
    {
		Todos todoadd = services.save(todos);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoadd.getId()).toUri();
		return  ResponseEntity.created(uri).build();

    }
}
