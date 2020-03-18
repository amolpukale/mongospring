package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IPersonDao;
import com.app.pojos.Person;

@Service
public class PersonService 
{
	@Autowired
	private IPersonDao dao;
	
	//create operation
	public Person create(String firstName,String lastName,int age)
	{
		return dao.save(new Person(firstName,lastName,age));
	}
	//retrieve operation
	public List<Person> getAll()
	{
		return dao.findAll();
	}
	public Person getByFirstName(String firstName)
	{
		return dao.findByFirstName(firstName);
	}
	//update operation
	public Person update(String firstName,String lastName,int age)
	{
		Person p=dao.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return dao.save(p);
	}
	//delete operation
	public void deleteAll()
	{
		dao.deleteAll();
	}
	public void delete(String firstName)
	{
		Person p=dao.findByFirstName(firstName);
		dao.delete(p);
	}
}
