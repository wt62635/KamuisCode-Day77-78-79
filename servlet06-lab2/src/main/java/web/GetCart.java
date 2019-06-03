package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 练习：写一个Servlet,该Servlet先查看有没有一个名称为“cart”的cookie, 如果有，则显示该cookie的值，
 * 如果没有，则添加该cookie的值。
 */
public class GetCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			//设置判断标签
			boolean confirm = false;
			//遍历查询浏览器的所有cookie
			for (Cookie c : cookies) {
				if ("cart".equals(c.getName())) {
					out.print("找到一条名为“cart”的Cookie!" + "<br>");
					out.print("“cart的值为：”" + c.getValue());
					confirm = true;
				}
			}
			if (!confirm) {//如果未找到"cart"则添加
				out.print("未找到名为“cart”的Cookie!将自动添加！" + "<br>");
				add(response);
				out.print("自动添加cart完毕！");
			}
		}else {
			out.print("cookie为null！没有找到任何cookie!");
			out.print("未找到名为“cart”的Cookie!将自动添加！" + "<br>");
			add(response);
			out.print("自动添加cart完毕！");
		}
		out.print("<br>"+"程序已结束");
	}
	
	//添加cart方法
	private void add(HttpServletResponse response) {
		Cookie cart = new Cookie("cart", "卡穆依");
		response.addCookie(cart);
	}
}
