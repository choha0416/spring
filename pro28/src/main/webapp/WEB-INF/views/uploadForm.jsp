<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- JSTL 라이브러리 추가 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <!-- JQuery 라이브러리 URL 수정 -->
    <script src="http://code.jquery.com/jquery-latest.js"></script>
    <script>
        var cnt = 1;
        function fn_addFile() {
            // input 태그에서 name 속성 수정: file + cnt 형태로 이름을 생성
            $("#d_file").append("<br><input type='file' name='file" + cnt + "' />");
            cnt++;
        }
    </script>
</head>
<body>
    <h1>파일 업로드 하기</h1>
    <form method="post" action="${contextPath}/upload" enctype="multipart/form-data">
        <label>아이디:</label>
        <input type="text" name="id"><br>
        <label>이름:</label>
        <input type="text" name="name"><br>
        <input type="button" value="파일추가" onclick="fn_addFile()"/><br>
        <div id="d_file"></div>
        <input type="submit" value="업로드"> 
    </form>
</body>
</html>
