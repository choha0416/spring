<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>

    <fmt:setLocale value='<%=request.getParameter("language") %>' />
    <fmt:bundle basename="bundle.message">
        <header class="pb-3 mb-5 border-bottom">
        	
            <div class="d-flex justify-content-between align-items-center">
                <!-- 홈 링크 -->
                <a href="${contextPath}/member/main.do" class="d-flex align-items-center text-dark text-decoration-none">

                    <span class="fs-4">관리페이지</span>
                </a>


               

            </div>   
            <nav class="py-2 bg-body-tertiary">
                <div class="container d-flex flex-wrap">
                    <ul class="nav me-auto">
 					<c:choose>
                            <c:when test="${isLogOn == true && member!=null}">
                        <li class="nav-item"><a href="listMembers.do" class="nav-link link-body-emphasis px-2 active" aria-current="page">회원관리</a></li>
                        <li class="nav-item"><a href="#" class="nav-link link-body-emphasis px-2">게시판관리</a></li>
                        <li class="nav-item"><a href="#" class="nav-link link-body-emphasis px-2">상품관리</a></li>
                    </c:when>
                    <c:otherwise>
                    <li class="nav-item">관리메뉴를 보려면 로그인 해주세요</li>
                    </c:otherwise>
                    </c:choose>
                    </ul>


                    <ul class="nav ms-auto">
                        <c:choose>
                            <c:when test="${isLogOn != true && member==null}">
                                <li class="nav-item">
                                    <a class="nav-link link-body-emphasis px-2 active" href="${contextPath }/member/loginForm.do">
                                        로그인
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link link-body-emphasis px-2 active" href="memberForm.do">
                                       회원가입
                                    </a>
                                </li>   
                            </c:when>
                            <c:otherwise>
                                <li style="padding-top:7px; color:black">[${member.name} 님]</li>
                                <li class="nav-item">
                                    <a class="nav-link link-body-emphasis px-2 active" href="${contextPath}/member/logout.do">
                                        로그아웃
                                    </a>
                                </li>
                          
                            </c:otherwise>
                        </c:choose>
                    </ul>
				
                </div>
            </nav>                       
        </header>    
    </fmt:bundle>
</body>
</html>
