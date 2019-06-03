package web;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 向浏览器发送Cookie
 * @author Administrator
 *
 */
public class AddCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//添加cookie
		Cookie c = new Cookie("uesrname","Kamui");
		c.setMaxAge(30);//设置生存时间为30秒
		response.addCookie(c);
	}

}
