<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
    <%
    	// jsp页面声明  session="false" 时，将不能自动创建session对象，需要如下方式
    	// request.getSession(false);如果没有session就返回false，如果访问了该项目其他页面生成了session，即返回当前session 对象
    	// request.getSession(); 等价于 request.getSession(true); 如果没有session则创建session
    	HttpSession session = request.getSession(false);
    	out.print(session);
    	out.print("<br>");
    	
    	if(session != null){
	    	out.print(session.getMaxInactiveInterval());
	    	session.invalidate();   //注销session
    		
    	}
    	
    %>
</body>
</html>