package com.in28min.angular.AngularandspringTodo.helloWorld;

import java.util.Date;
import java.util.Objects;

import org.springframework.stereotype.Component;


public class Todos {
	
	private int id;
	private String Username;
	private String description;
	private Date targetDate;
	private boolean isDone;
	
	protected Todos()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	public boolean isDone() {
		return isDone;
	}
	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	public Todos(int id, String username, String description, Date targetDate, boolean isDone) {
		super();
		this.id = id;
		Username = username;
		this.description = description;
		this.targetDate = targetDate;
		this.isDone = isDone;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todos other = (Todos) obj;
		return id == other.id;
	}
	
	
	
	
}
