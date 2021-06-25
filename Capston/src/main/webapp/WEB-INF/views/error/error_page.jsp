<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
</head>
<body>
	<c:if test="${requestScope['javax.servlet.error.status_code'] == 400}">
		<p>잘못 된 요청입니다.</p>    
	</c:if>	
	
	<c:if test="${requestScope['javax.servlet.error.status_code'] == 404}">
		<p>요청하신 페이지를 찾을 수 없습니다.</p>    
	</c:if>
	
	<c:if test="${requestScope['javax.servlet.error.status_code'] == 405}">
		<p>요청된 메소드가 허용되지 않습니다.</p>    
	</c:if>
	
	<c:if test="${requestScope['javax.servlet.error.status_code'] == 500}">
		<p>잘못된 형식의 값을 입력하셨습니다. 다시 입력해주시기 바랍니다.</p>
	</c:if>
	
	<c:if test="${requestScope['javax.servlet.error.status_code'] == 503}">
		<p>서비스를 사용할 수 없습니다.</p>
	</c:if>
	
	<a href="/move/index">Home</a>
	<a href="javascript:history.back(-1)">뒤로가기</a>
</body>
</html>