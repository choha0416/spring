<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL 라이브러리 추가 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>회원 수정</title>
</head>
<body>
 <div class="container my-5">
<%@ include file="/WEB-INF/views/common/menu.jsp" %>
	<div class="container py-4 d-flex justify-content-center">
		<div class="col-md-6">
			<h1 class="text-center">회원 정보 수정</h1>
			<div class="row">
				<form method="post" action="${contextPath}/member/updateMember.do">
					<div class="mb-3 row">
						<label class="col-sm-3">아이디</label>
						<div class="col-sm-9">
							<input type="text" name="id" class="form-control" value="${member.id}" readonly >
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-3">비밀번호</label>
						<div class="col-sm-9">
							<input type="password" name="pwd" class="form-control" required>
							
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-3">이름</label>
						<div class="col-sm-9">
							<input type="text" name="name" class="form-control"  required>
						</div>
					</div>
					<div class="mb-3 row">
						<label class="col-sm-3">이메일</label>
						<div class="col-sm-9">
							<input type="email" name="email" class="form-control" required>
						</div>
					</div>
					<div class="mb-3 row text-center">
						<div class="col-sm-12">
							<input type="submit" value="수정 하기" class="btn btn-primary">
							<input type="reset" value="다시 입력" class="btn btn-secondary ms-3">
						</div>
					</div>
				</form>
			</div>
		</div>
		
	</div>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
</body>
</html>
