<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>재능기부판매_수정</title>
</head>
<body>
    <!-- Talent_S Members -->
    <section id="container">
   
		<div id="wrapper"> 
<div id="content">
		
			    <h1 class="mt-4 mb-3">재능기부물품판매 수정
			
<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">

<input type="hidden" name="tals_Code" value="${talent.tals_Code}" />


<div class="inputArea">
 <label for="tals_Title">제목</label>
 <input type="text" id="tals_Title" name="tals_Title" value="${talent.tals_Title}"/>
</div>
<div class="inputArea">
 <label for="tals_Kinds">종류</label>
 <input type="text" id="tals_Kinds" name="tals_Kinds" value="${talent.tals_Kinds}"/>
</div>
<div class="inputArea">
 <label for="tals_Content">내용</label>
 <input type="text" id="tals_Content" name="tals_Content" value="${talent.tals_Content}"/>
</div>
<div class="inputArea">
 <label for="tals_Price">가격</label>
 <input type="text" id="tals_Price" name="tals_Price" value="${talent.tals_Price}"/>
</div>
<div class="inputArea">
 <button type="submit" id="update_Btn" class="btn btn-primary">완료</button>
 <input type="button" value="뒤로 가기" onclick="history.back(-1)">
</div>   

</form>
			
		</div>
	</section>
</body>
</html>