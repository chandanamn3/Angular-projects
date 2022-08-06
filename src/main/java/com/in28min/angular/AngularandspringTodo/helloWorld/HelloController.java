package com.in28min.angular.AngularandspringTodo.helloWorld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class HelloController {
	@GetMapping("/hello")
	public String HelloWorld()
	{
		return "helloWorld";
	}
	@GetMapping("/helloBean")
	public HelloWorldBean HelloWorldBean()
	{
		return new HelloWorldBean("helloWorld -Spring");
	}
	
	@GetMapping("/helloBean/{name}")
	public HelloWorldBean HelloWorldBeanParam(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("helloWorld,%s",name));
	}

}
