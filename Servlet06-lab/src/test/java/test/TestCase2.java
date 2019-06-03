package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import dao.UserDAO;
import entity.User;

public class TestCase2 {
	private UserDAO dao;
	
	@Test
	public void test3() throws Exception {
		dao.del(20);
	}
	
	@Test
	public void test1() throws Exception {
		List<User> users = dao.findAll();
		System.out.println(users);
	}
	
	@Before
	/*
	 * @Before修饰的方法会在其他测试方法运行前先执行。
	 */
	public void intt() {
		dao = new UserDAO();
	}
	
	@Test
	public void test2() throws Exception {
		User user = new User();
		user.setUname("洛丹伦第一孝子");
		user.setPwd("312");
		user.setEmail("arsasi@test.com");
		user.setId(20);
		dao.save(user);
	}
}
