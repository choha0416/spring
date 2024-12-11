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
<form action="${contextPath}/mem3.do">
	입력: <input type="text" name="value"/>
	<select name="action">
		<option value="listMembers">전체</option>
		<option value="selectMemberById">아이디</option>
		<option value="selectMemberByPwd">비밀번호</option>
	</select><br>
	<input type="submit" value="검색"/>
</form>
</body>
</html>