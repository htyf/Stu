<%@page import="com.oaec.model.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resource/js/student.js"></script>
    <meta charset="UTF-8">
    <title>个人信息修改</title>
    <style>
        *{
            padding:0;
            margin:0;
        }
        table{
            margin:0 auto;
            margin-top:100px;
        }
        caption{
            margin:10px 0 40px 0;
            font-size:18px;
            font-weight:bold;
        }
        table th{
            width:40%;
            padding:10px 10px;
        }
        table input{
            width:348px;
            height:40px;
            font-size:18px;
            line-height:30px;
            padding-left:10px;
        }
        .btn{
            margin-top:40px;
        }
        .btn button{
           /* margin:0 55px;*/
            width:100px;
        }
    </style>
</head>
<body>
<form action="stuList?action=update" method="post">
<table border="1" cellpadding="0" cellspacing="0" bgcolor="#e0ead7" align="center" width="35%">
    <caption>学生信息管理系统</caption>
    <%
   Student stu = (Student)request.getAttribute("stu");
    %>
    <tbody>
        <tr>
        <input type="hidden" name="id" value="<%=stu.getSid() %>" />
            <th>姓名：</th>
            <td><input type="text" value="<%=stu.getSname() %>" name="name"></td>
        </tr>
        <tr>
            <th>年龄：</th>
            <td><input type="text" name="age" value="<%=stu.getSage() %>"></td>
        </tr>
        <tr>
            <th>性别：</th>
            <td><input type="text" name="sex" value="<%=stu.getSsex() %>"></td>
        </tr>
        <tr>
            <th>电话：</th>
            <td><input type="text" name="phone" value="<%=stu.getSphone() %>"></td>
        </tr>
    </tbody>
</table>
<div class="btn" width="20%" align="center">
    <button type="submit">更新</button>
    <button>重置</button>
</div>
</form>
</body>
</html>