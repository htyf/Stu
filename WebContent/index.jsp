<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.oaec.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
<script type="text/javascript" src="resource/js/student.js"></script>
<style>
* {
	padding: 0;
	margin: 0;
}

table {
	margin: 0 auto;
	margin-top: 100px;
	/*  width:1266px;*/
}

caption {
	margin: 10px 0 62px 0;
	font-size: 18px;
	font-weight: bold;
}

.btn {
	width: 250px;
	margin-top: 20px;
	margin-left: 156px;
	float: left;
}

.btn button {
	margin-right: 20px;
}

.btn a {
	text-decoration: none;
	color: #000;
	padding: 4px 8px;
}

ul {
	list-style: none;
	margin-right: 156px;
	overflow: hidden;
	margin-top: 20px;
	float: right;
	border-radius: 5px;
}

ul li {
	float: left;
	line-height: 30px;
	text-align: center;
}

ul li a {
	color: #000;
	text-decoration: none;
	display: block;
	padding: 0 14px;
	border: 1px solid #ccc;
	background: #e0ead7;
}

ul li.current a {
	background: #fff;
	border: none;
}
</style>

</head>
<body>
<%
request.getCookies();
%>
	<table width="80%" border="0" cellpadding="0" cellspacing="1"
		bgcolor="#e0ead7" align="center">
		<caption>学生信息管理系统</caption>
		<thead>
			<tr>
				<td width="20%" height="40" align="center" bgcolor="#eaf2e2"><strong>全选<input
						type="checkbox" name="" id="checkAll" onclick="checkAll()"></strong></td>
				<td width="20%" height="40" align="center" bgcolor="#eaf2e2"><strong>姓名</strong></td>
				<td width="20%" height="40" align="center" bgcolor="#eaf2e2"><strong>年龄</strong></td>
				<td width="20%" height="40" align="center" bgcolor="#eaf2e2"><strong>性别</strong></td>
				<td width="20%" align="center" bgcolor="#eaf2e2"><strong>电话</strong></td>
			</tr>
		</thead>

		

<c:forEach var="i" begin="0" end="${stuList.size()-1 }">
<c:set var="stu" scope="page" value="${stuList.get(i)}"/>
		<tr>
			<input type="hidden" name="sid" value="${stu.getSid()}" />
			<td height="40" align="center" bgcolor="#fafafa"><input
				type="checkbox" name="checkSub" value=${stu.getSid()}></td>
			<td height="40" align="center" bgcolor="#fafafa">${stu.getSname() }</td>
			<td height="40" align="center" bgcolor="#fafafa">${stu.getSage()}</td>
			<td height="40" align="center" bgcolor="#fafafa">${stu.getSsex()}</td>
			<td align="center" bgcolor="#fafafa">${stu.getSphone() }</td>
		</tr>

</c:forEach>
		

	</table>
	<div class="btn">
		<a href="add.jsp"><button>
			添加
		</button></a>
		<button onclick="stuDel()">删除</button>
		<button onclick="updateStu()">修改</button>
	</div>
	<%
		int totalPage = (Integer) request.getAttribute("pageNum");
		int nowpage = (Integer) request.getAttribute("page");
	%>
	<ul>
		<%
			if (nowpage-1 < 1) {
		%>
		<li><a href="#">上一页</a></li>
		<%
			} else {
		%>
		<li><a href="stuList?page=<%=nowpage - 2%>">上一页</a></li>
		<%
			}
		%>
		<%
			for (int i = 1; i <= totalPage; i++) {
				if (nowpage == i) {
		%>
		<li value="<%=i%>" class='current'><a href="#"><%=i%></a></li>
		<%
			} else {
		%>
		<li value="<%=i%>" ><a href="#"><%=i%></a></li>
		<%
			}
			}
		%>

		<%
			if (nowpage == totalPage) {
		%>
		<li><a href="#">下一页</a></li>
		<%
			} else {
		%>
		<li><a href="stuList?page=<%=nowpage%>">下一页</a></li>
		<%
			}
		%>
	</ul>
</body>
</html>