package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
/**
 * 查询所有用户信息数据处理
 * @author Administrator
 *
 */
public class ListUserServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 将所有用户信息查询出来
		UserDAO dao = new UserDAO();
		try {
			List<User> users = dao.findAll();
			//※转发
			//第一步：将数据绑定到request
			request.setAttribute("users", users);
			//第二步：获得转发器
			RequestDispatcher rd = request.getRequestDispatcher("listUser.jsp");
			//第三步：进行转发
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试。");
		}
	}
}
