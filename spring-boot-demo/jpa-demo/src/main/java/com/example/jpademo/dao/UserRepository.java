package com.example.jpademo.dao;

import com.example.jpademo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {

	List<User> findByName(String name);

	List<User> findByNameAndAge(String name, Integer age);

	@Query("from User u where u.name=:name")
	List<User> findUser(@Param("name") String name);
}
