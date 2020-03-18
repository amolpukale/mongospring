package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Person;
import com.app.service.PersonService;

@RestController
public class PersonController 
{
	public PersonController() {
		// TODO Auto-generated constructor stub
	System.out.println("in Person controller");
	}
	
	@Autowired
	private PersonService service;
	
	@RequestMapping("/create")
	public String create(@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age)
	{
		Person p=service.create(firstName, lastName, age);
		return p.toString();
	}
	@RequestMapping("/getAll")
	public List<Person> getAll()
	{
		return service.getAll();
	}
	@RequestMapping("/get")
	public Person getPerson(@RequestParam String firstName)
	{
		return service.getByFirstName(firstName);
	}
	@RequestMapping("/update")
	public String update(@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age)
	{
		Person p=service.update(firstName, lastName, age);
		return p.toString();
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam String firstName)
	{
		service.delete(firstName);
		return "deleted"+firstName;
	}
	@RequestMapping("/deleteAll")
	public String deleteAll()
	{
		service.deleteAll();
		return "Deleted all records";
	}
}
