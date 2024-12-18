<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>결과창</title>
</head>
<body>
	<h1>업로드가 완료되었습니다</h1>
	<label>아이디:</label>
	<input type="text" name="id" value="${map.id}" readonly><br> <!-- value에 따옴표 추가 -->
	<label>이름:</label>
	<input type="text" name="name" value="${map.name}" readonly><br> <!-- value에 따옴표 추가 -->
	<div class="result-images">
		<c:forEach var="imageFileName" items="${map.fileList}">
			<img src="${pageContext.request.contextPath}/download?imageFileName=${imageFileName}" alt="Uploaded Image"><br><br><br> <!-- src에 따옴표 추가 -->
		</c:forEach>
	</div>
	<p>
		<a href="${pageContext.request.contextPath}/form">다시 업로드하기</a> <!-- href에 따옴표 추가 -->
	</p>
</body>
</html>
