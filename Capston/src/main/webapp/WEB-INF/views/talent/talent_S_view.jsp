<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재능기부 판매 조회</title>
</head>
<body>

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">재능판매물품_상세</h1>

	<form role="form" method="post" autocomplete="off">
			
	<input type="hidden" name="n" value="${talent.tals_Code}"/>

    <!-- Intro Content -->
    <div class="row">
      <div class="col-lg-6">
        <div class="inputArea">
				<label for="tals_Title">재능판매_제목</label>
				<span>${talent.tals_Title}</span>
		</div>
		 <div class="inputArea">
				<label for="tals_Kinds">재능판매_종류</label>
				<span>${talent.tals_Kinds}</span>
		</div>
		<div class="inputArea">
				<label for="tals_Content">재능판매_내용</label>
				<span>${talent.tals_Content}</span>
		</div>
		<div class="inputArea">
				<label for="tals_Price">재능판매_가격</label>
				<span>${talent.tals_Price}</span>
		</div>
		<div class="inputArea">
				<label for="tals_Term">재능판매_텀</label>
				<span>${talent.tals_Term}</span>
		</div>
		<div class="inputArea">
				<label for="phone_Num">핸드폰_번호</label>
				<span>${talent.phone_Num}</span>
		</div>
		<div class="inputArea">
				<label for="tals_Date">재능판매글올린_날짜</label>
				<span>${talent.tals_Date}</span>
		</div>
		<div class="inputArea">
				<label for="tals_Id">재능판매_글쓴사람</label>
				<span>${talent.tals_Id}</span>
		</div>
      </div>
    </div>
    
      </div>
  <c:choose>
  <c:when test = "${member.id eq talent.tals_Id}">
<a href="/talent/talent_S_modify?n=${talent.tals_Code}">게시물 수정</a><hr/>
<a href="/talent/talent_S_delete?n=${talent.tals_Code}">게시물  삭제</a>
</c:when>

</c:choose>
<a href="/talent/talent_S_list">게시물  리스트</a>
</body>
</html>