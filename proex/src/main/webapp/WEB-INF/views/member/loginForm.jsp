<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css"><meta charset="utf-8">
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>

    <div class="container py-4">
    <%@ include file="/WEB-INF/views/common/menu.jsp" %>


        <div class="row align-items-md-stretch text-center">
            <div class="row justify-content-center align-items-center">
                <div class="h-100 p-5 col-md-6">
                    <h3>Please sign in</h3>

                    <%
                        String error = request.getParameter("error");
                        if ("true".equals(error)) {
                            out.println("<div class='alert alert-danger'>아이디와 비밀번호를 확인해 주세요.</div>");
                        }
                    %>
                    <form class="form-signin" action="${contextPath}/member/login.do" method="post">
                        <div class="form-floating mb-3 row">
                            <input type="text" class="form-control" id="id" name="id" required autofocus>
                            <label for="floatingInput">ID</label>
                        </div>
                        <div class="form-floating mb-3 row">
                            <input type="password" class="form-control" id="pwd" name="pwd">
                            <label for="floatingInput">Password</label>
                        </div>
                        <button class="btn btn-lg btn-success" type="submit">로그인</button>
                    </form>
                </div>
            </div>
        </div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </div>

</body>
</html>
