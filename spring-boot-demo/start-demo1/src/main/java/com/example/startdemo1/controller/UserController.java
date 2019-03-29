package com.example.startdemo1.controller;

import com.example.startdemo1.entity.User;
import io.swagger.annotations.*;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api("用户controller1")
@Description("用户controller")
public class UserController {

	@GetMapping("")
	@Description("查询用户列表信息")
	@ApiOperation("查询用户列表信息")
	@ApiResponses({
			@ApiResponse(code=200, message = "正常返回"),
			@ApiResponse(code=404, message = "请求找不到"),
			@ApiResponse(code=500, message = "请求错误"),
	})
	public List<User> getUserList() {
		List<User> userList = new ArrayList<>();
		return userList;
	}

	@PostMapping("")
	@ApiOperation(value="创建用户信息", notes = "根据用户信息创建用户")
	@ApiImplicitParam(name = "user", value="用户详细信息实体", required = true, dataType = "User")
	public String saveUser(@RequestBody User user) {
		System.out.println("save :" + user);
		return "SUCCESS";
	}

	@GetMapping("{id}")
	@ApiOperation(value="根据用户id获取用户信息", notes="根据url中的用户id获取对应用户详情")
	@ApiImplicitParam(name="id", value="用户的id", required = true, dataType = "String")
	public User getUser(@PathVariable("id") String id) {
		System.out.println("get user id :" + id);
		return User.builder().id(id).build();
	}

	@PutMapping("{id}")
	@ApiOperation(value="更新用户信息", notes = "根据url中的用户id 和 请求体中的用户信息更新用户信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name="id", value="用户的id", required = true, dataType = "String"),
			@ApiImplicitParam(name="user", value="用户实体信息", required = true, dataType = "User")
	})
	public String putUser(@PathVariable("id") String id,@RequestBody User user) {
		System.out.println("update user " + user);
		System.out.println("update id " + id);
		return "SUCCESS";
	}

	@DeleteMapping("{id}")
	@ApiOperation(value="根据用户id删除用户信息", notes="根据url中的用户id删除对应用户信息")
	@ApiImplicitParam(name="id", value="用户的id", required = true, dataType = "String")
	public String deleteUser(@PathVariable("id") String id) {
		System.out.println("delete id " + id);
		return "SUCCESS";
	}



}
