<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<html>
<head></head>
<body>
time:<%=new Date() %><!-- jsp表达式 --><br>

now:<%
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
	out.println(sdf.format(date));
%>
</body>
</html>