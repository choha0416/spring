<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL 라이브러리 추가 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
    <table border="1" align="center">    
            <tr>
                <th>ID</th>
                <th>Password</th>
                <th>Name</th>
                <th>Email</th>
                <th>Join Date</th>
               
            </tr>
            
	<c:forEach var="member" items="${membersList}">
                <tr align="center">
                    <td>${member.id }</td>
                    <td>${member.pwd }</td>
                    <td>${member.name }</td>
                    <td>${member.email }</td>
                    <td>${member.joinDate }</td>
                </tr>
            </c:forEach>     
    </table>
   
</body>
</html>
