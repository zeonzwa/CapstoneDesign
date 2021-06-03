<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
 <title>>재능기부 판매 게시판 글쓰기</title>
</head>
<body>

<div id="root">
 <header>
  <h1>재능기부 판매 게시판 글쓰기</h1>
 </header>

<hr />

 <section id="container">
 
  <form role="form" method="post" autocomplete="off">
   <p>
    <label for="Tals_Title">글 제목</label><input type="text" id="Tals_Title" name="Tals_Title" />
   </p>
   <p>
    <label for="Tals_Kinds">글 종류</label><input type="text" id="Tals_Kinds" name="Tals_Kinds" />
   </p>
   <p>
    <label for="Tals_Content">글 내용</label><textarea id="Tals_Content" name="Tals_Content"></textarea>
   </p>
   <p>
    <label for="Tals_Price">가격</label><input type="text" id="Tals_Price" name="Tals_Price" />
   </p>
   <p>
    <label for="Tals_Term">텀</label><input type="text" id="Tals_Term" name="Tals_Term" />
   </p>
   <p>
    <button type="submit">작성</button>
   </p>  
  </form>

 </section>

<hr />

</div>

</body>
</html>