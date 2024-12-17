<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
 <div class="container my-5">
    <%@ include file="/WEB-INF/views/common/menu.jsp" %>
	<h1>메인페이지 입니다</h1>
	<p> 기능을 사용하시려면 로그인 하세요!
        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </div>
</body>
</html>