package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
/**
 * 添加用户数据处理
 * @author Administrator
 *
 */
public class AddUserServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		// 读取用户信息
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		System.out.println(username);
		
		// 将用户信息插入到数据库
		UserDAO dao = new UserDAO();
		try {
			User user = new User();
			user.setUname(username);
			user.setPwd(pwd);
			user.setEmail(email);
			dao.save(user);
			
			//重定向到用户列表
			response.sendRedirect("list");
			
		} catch (Exception e) {
			/*
			 * step1.记日志。
			 * 将异常的所有信息记录下来，一般会记录到文件里面
			 */
			e.printStackTrace();
			/*
			 * step2.看异常能否恢复，如果不能恢复
			 * （比如，数据库服务暂停，网络中断等，
			 * 一般把这样的异常称之为系统异常），
			 * 则提示用户稍后重试。如果能够恢复，则立即恢复。
			 */
			out.println("系统繁忙，请稍后再试。");
		}
	}
}
