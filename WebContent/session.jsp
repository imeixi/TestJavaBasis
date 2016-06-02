<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%= session.getId() %>

	<%
		//将session进行本地持久化，保存到本地cookie文件中
		//默认session会保存在内存中，关闭浏览器即失效
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(120);
		response.addCookie(cookie); 
	%>
</body>
</html>