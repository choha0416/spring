<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frmLogin" action="${contextPath}/test/login.do" method="post">
		<table border="1" width="80%" align="center">
			<tr align="center">
				<td>아이디</td>
				<td>비밀번호</td>
			</tr>
			<tr align="center">
				<td><input type="text" name="userID" id="userID" value="" size="20"></td>
				<td><input type="password" name="passwd" id="passwd" value="" size="20"></td>
			</tr>
			<tr align="center">
				<td><input type="submit"value="등록하기"> </td>
				
			</tr>
		</table>
	</form>
</body>
</html>