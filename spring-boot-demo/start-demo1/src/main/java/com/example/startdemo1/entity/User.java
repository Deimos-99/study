package com.example.startdemo1.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户实体")
public class User {

	@ApiModelProperty(value="用户id", required = true, dataType = "String")
	private String id;

	@ApiModelProperty(value="用户姓名", dataType = "String")
	private String name;

	@ApiModelProperty(value="用户年龄",dataType = "Integer")
	private Integer age;



}
