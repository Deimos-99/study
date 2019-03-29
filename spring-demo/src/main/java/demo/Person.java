package demo;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
public class Person {

	private String name;
	private Integer age;
	private String desc;

}
