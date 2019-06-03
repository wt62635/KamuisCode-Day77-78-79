<%@page import="java.util.*" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head></head>
<body style="frot-size: 30ps;">
	time:<%
	Date date = new Date();
	out.println(date);
%>
	<%
		for (int i = 0; i < 100; i++) {
			out.println("Hello Kamui<br/>");
		}
	%>

</body>
</html>