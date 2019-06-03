package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
/**
 * 删除用户数据处理
 * @author Administrator
 *
 */
public class DelUserServlet extends HttpServlet{
	public void service(HttpServletRequest request , HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//获取要删除的id参数
		int id = Integer.parseInt(request.getParameter("id"));
		UserDAO dao = new UserDAO();
		try {
			dao.del(id);
			//重定向到用户列表
			response.sendRedirect("list");
			
		} catch (Exception e) {
			e.printStackTrace();
			out.println("系统繁忙，请稍后再试。");
		}
	}
}
