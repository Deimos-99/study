package com.example.jpademo.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private BigInteger id;

	@Column(name="name")
	private String name;

	@Column(name="age")
	private Integer age;

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}
