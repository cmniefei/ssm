<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>user列表</title>
</head>
<body style="padding:100px">
	<div class="container" >
	
		<table class="table table-hover table-bordered">
			<tr>
				<td>id</td>
				<td>名称</td>
				<td>年龄</td>
			</tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.username }</td>
					<td>${user.age }</td>
				</tr>
			</c:forEach>
	
		</table>
		
		<form action="add">
			<div class="form-group">
				<label for="username" class="form-label">姓名</label>
				<input name="username" id="username" type="text" class="form-control">
			</div>
			<div class="form-group">
				<label for="age" class="form-label">年龄</label>
				<input name="age" id="age" type="text" class="form-control">
			</div>
			
			<button type="submit" class="btn btn-primary"> 提交</button>
		
		</form>
		
	
	</div>

</body>
</html>