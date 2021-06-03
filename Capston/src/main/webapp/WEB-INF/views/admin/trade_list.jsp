<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
 <title>재능기부 판매 게시판 리스트</title>
</head>
<body>

<div id="root">
 <header>
  <h1>재능기부 판매 게시판 리스트</h1>
 </header>
<hr /> 
   <a href="/talent/talent_S_reg">글쓰기</a>
  <table>
   <tr>
   <th>글 번호</th>
   <th>글 제목</th>
   <th>글종류</th>
   <th>텀</th>
   <th>폰번호</th>
   <th>작성일자</th>
   <th>글쓴이</th>
   </tr>
   
   <!-- 목록 시작 -->
   <c:forEach items="${list}" var="list">
   <tr>
    <td><a href="/talent/talent_S_view?n=${list.tals_Code}">${list.tals_Code}</a></td>
    <td>${list.tals_Title}</td>
    <td>${list.tals_Kinds}</td>
    <td>${list.tals_Term}</td>
    <td>${list.phone_Num}</td>
    <td><fmt:formatDate value="${list.tals_Date}" pattern="yyyy-MM-dd" /></td>
    <td>${list.tals_Id}</td>
   </tr>
   </c:forEach>
   <!-- 목록 끝 -->
   
  </table>

 </section>

<hr />

</div>

</body>
</html>