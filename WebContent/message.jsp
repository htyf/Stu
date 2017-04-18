<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>  
function jumpurl(){  
  location='stuList';  
}  
setTimeout('jumpurl()',3000);  
</script> 
</head>
<body>
<%
String tip = (String)request.getAttribute("tips");
%>
<h1><%=tip %></h1>
<a href="stuList">3秒后系统会自动跳转主界面，也可点击本处直接跳</a> </div></div></div>   
  
</body>
</html>