package com.app.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Person;
@Repository
public interface IPersonDao extends MongoRepository<Person, String>
{
	public Person findByFirstName(String firstName);
	public List<Person> findByAge(int age);
}
