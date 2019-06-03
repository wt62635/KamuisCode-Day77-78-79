package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 读取浏览器端发送过来的Cookie
 * @author Administrator
 *
 */
public class FindCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		//读取Cookie读取Cookie请求
		Cookie[] cookies = request.getCookies();
		//有可能没有任何cookie，所以一定要做非空判断
		if(cookies != null) {
			for (Cookie c : cookies) {
				//获得cookie的名字与值
				String name = c.getName();
				String value = c.getValue();
				pw.println(name + "" + value + "<br>");
			}
		}else {
			pw.print("没有发现任何Cookie");
		}
	}

}
