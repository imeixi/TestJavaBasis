<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie:cookies){
				out.print(cookie.getName() + ":" + cookie.getValue());
				out.print("<br>");
			}
		}else{
			out.print("没有一个Cookie，正在创建");
			Cookie cookie = new Cookie("user","root");
			cookie.setMaxAge(1800);
			response.addCookie(cookie);
		}
	%>
</body>
</html>