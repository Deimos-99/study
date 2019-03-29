package com.example.jpademo.dao;

import com.example.jpademo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() {
		// 创建10条记录
		userRepository.save(new User("A", 10));
		userRepository.save(new User("B", 20));
		userRepository.save(new User("C", 30));
		userRepository.save(new User("D", 40));
		userRepository.save(new User("E", 50));
		userRepository.save(new User("F", 60));
		userRepository.save(new User("G", 70));
		userRepository.save(new User("H", 80));
		userRepository.save(new User("I", 90));
		userRepository.save(new User("J", 100));

		// 测试findAll, 查询所有记录
		Assert.assertEquals(10, userRepository.findAll().size());

		// 测试findByName, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findByName("F").get(0).getAge().longValue());

		// 测试findUser, 查询姓名为FFF的User
		Assert.assertEquals(60, userRepository.findUser("F").get(0).getAge().longValue());

		// 测试findByNameAndAge, 查询姓名为FFF并且年龄为60的User
		Assert.assertEquals("F", userRepository.findByNameAndAge("F", 60).get(0).getName());

		// 测试删除姓名为AAA的User
		userRepository.delete(userRepository.findByName("A").get(0));

		// 测试findAll, 查询所有记录, 验证上面的删除是否成功
		Assert.assertEquals(9, userRepository.findAll().size());
	}
}
