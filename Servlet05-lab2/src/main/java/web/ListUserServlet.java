package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
			// 依据查询到的用户信息，输出表格
			out.println("<table width='60%' border='1' cellpadding='0'>");
			out.println("<tr>" 
					+ "<td>ID</td>" 
					+ "<td>用户名</td>" 
					+ "<td>密码</td>" 
					+ "<td>邮箱</td>" 
					+ "<td>操作</td>" 
					+"</tr>");
			for (User u : users) {
				int id = u.getId();
				String username = u.getUname();
				String password = u.getPwd();
				String email = u.getEmail();
				out.println("<tr>"
						+ "<td>" + id + "</td>"
						+ "<td>" + username + "</td>"
						+ "<td>" + password + "</td>"
						+ "<td>" + email + "</td>"
						+ "<td><a href='del?id=" + id + "'>删除"+ "</td>"
						+ "</tr>");
			}
			out.println("</table>");
			out.println("<p><a href='addUser.html'>添加用户</a></p>");
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，稍后重试。");
		}

	}
}
