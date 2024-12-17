<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>회원 관리</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <div class="container my-5">
    <%@ include file="/WEB-INF/views/common/menu.jsp" %>
        <h2 class="text-center mb-4">회원 관리</h2>
        <table class="table table-bordered table-striped">
            <thead>
                <tr class="table-dark text-center">
                    <th>ID</th>
                    <th>Password</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Join Date</th>
                    <th>삭제</th>
                    <th>수정</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="member" items="${membersList}">
                    <tr class="text-center">
                        <td>${member.id}</td>
                        <td>${member.pwd}</td>
                        <td>${member.name}</td>
                        <td>${member.email}</td>
                        <td>${member.joinDate}</td>
                        <td><a href="${contextPath}/member/removeMember.do?id=${member.id}" class="btn btn-danger btn-sm">삭제</a></td>
                        <td><a href="${contextPath}/member/modMember.do?id=${member.id}" class="btn btn-warning btn-sm">수정</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
     <!--  
        <div class="text-center">
            <a href="${contextPath}/member/memberForm.do" class="btn btn-success">회원 가입</a>
        </div>
        
         -->  
        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </div>
</body>
</html>
