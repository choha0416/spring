<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL 라이브러리 추가 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>회원 가입창</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        .submit-btn-container {
            text-align: center;
            margin-top: 20px; 
        }
        .text_center {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container py-4">
     <%@ include file="/WEB-INF/views/common/menu.jsp" %>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <h1 class="text_center">회원 가입창</h1>
                <form method="get" action="${contextPath}/member/addMember.do">
                    <div class="mb-3 row">
                        <label for="id" class="col-sm-3 col-form-label">아이디</label>
                        <div class="col-sm-9">
                            <input type="text" name="id" id="id" class="form-control" required>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="pwd" class="col-sm-3 col-form-label">비밀번호</label>
                        <div class="col-sm-9">
                            <input type="password" name="pwd" id="pwd" class="form-control"required>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="name" class="col-sm-3 col-form-label">이름</label>
                        <div class="col-sm-9">
                            <input type="text" name="name" id="name" class="form-control"required>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="email" class="col-sm-3 col-form-label">이메일</label>
                        <div class="col-sm-9">
                            <input type="email" name="email" id="email" class="form-control"required>
                        </div>
                    </div>
                    <div class="mb-3 row text-center">
                        <div class="col-sm-12">
                            <input type="submit" value="가입 하기" class="btn btn-primary">
                            <input type="reset" value="다시 입력" class="btn btn-secondary ms-3">
                        </div>
                    </div>
                </form>
            </div>
        </div>
         <%@ include file="/WEB-INF/views/common/footer.jsp" %>
    </div>
</body>
</html>
