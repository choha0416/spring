<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL 라이브러리 추가 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>

    .submit-btn-container {
        text-align: center;
        margin-top: 20px; 
    }
</style>
</head>
<body>
    <!--<form method="post" action="${contextPath}/mem4.do?action=insertMember">  -->
         <form method="post" action="${contextPath}/mem4.do?action=insertMember2">
        <h1 class="text_center" align="center">회원 가입창</h1>
        <table align="center">
            <tr>
                <td width="200"><p align="right">아이디</p></td>
                <td width="400"><input type="text" name="id"></td>
            </tr>
            <tr>
                <td width="200"><p align="right">비밀번호</p></td>
                <td width="400"><input type="password" name="pwd"></td>
            </tr>
            <tr>
                <td width="200"><p align="right">이름</p></td>
                <td width="400"><input type="text" name="name"></td>
            </tr>
            <tr>
                <td width="200"><p align="right">이메일</p></td>
                <td width="400"><input type="text" name="email"></td>
            </tr>
            <tr>
                <td colspan="2" class="submit-btn-container">
                    <input type="submit" value="가입 하기">
                    <input type="reset" value="다시 입력">
                </td>
            </tr>      
        </table>
       
    </form>
</body>
</html>
