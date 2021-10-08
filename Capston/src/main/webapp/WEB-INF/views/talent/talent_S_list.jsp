<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>재능판매 리스트</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
   <!--  add CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/web.css" rel="stylesheet" type="text/css">
<style>
.card-img-top { width:418px; height:250px; }

</style>

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/move/index">충대 장터</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/move/contact">공지사항</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link" href="/admin/trade_list"> 중고장터</a>
          </li>
          <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              재능장터
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="/talent/talent_S_list?n=디자인">디자인</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=번역/외국어">번역/외국어</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=문서작성">문서작성</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=음악/영상">음악/영상</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=프로그램개발">프로그램개발</a>
              <a class="dropdown-item" href="/talent/talent_S_list?n=생활서비스">생활서비스</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              마이페이지
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="/move/uploaded">등록한 중고/재능</a>
              <a class="dropdown-item" href="/move/trade">거래요청받은 중고/재능거래</a>
              <a class="dropdown-item" href="/move/wantbuy">거래요청한 중고/재능거래</a>
              <a class="dropdown-item" href="/move/trade_complete">거래완료(후기작성)</a>
              <a class="dropdown-item" href="/move/review">후기관리</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPages" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              FAQ
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPages">
              <a class="dropdown-item" href="/move/faq1">자주찾는 질문</a>
              <a class="dropdown-item" href="/move/faq2">1:1문의</a>
            </div>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/member/logout">로그아웃</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">
<a href="/talent/talentlistSearch"  class="btn btn-primary">재능판매 검색 &rarr;</a>
    <!-- Page Heading/Breadcrumbs -->
    <h1 id ="talb_list_title" class="mt-4 mb-3">재능판매 장터
    <button id = "reg" onclick="location.href='/talent/talent_S_reg'">등록</button>
    
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="talent_S_list">재능판매</a>
      </li>
      <li class="breadcrumb-item active">재능판매 리스트</li>
    </ol>
  	<c:if test="${Kinds eq '디자인'}">
  	<a class="dropdown-item" href="/talent/talent_S_list?n=디자인">전체보기</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=웹디자인/상세페이지">웹디자인/상세페이지</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=포토샵편집">포토샵편집</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=일러스트/캐릭터">일러스트/캐릭터</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=3D모델링/도면">3D모델링/도면</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=기타디자인">기타디자인</a>
  	</c:if>
  	<c:if test="${Kinds eq '번역/외국어'}">
  	<a class="dropdown-item" href="/talent/talent_S_list?n=번역/외국어">전체보기</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=영어">영어</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=중국어">중국어</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=일본어">일본어</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=한자">한자</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=기타외국어">기타외국어</a>
  	</c:if>
  	<c:if test="${Kinds eq '문서작성'}">
  	<a class="dropdown-item" href="/talent/talent_S_list?n=문서작성">전체보기</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=프레젠테이션/엑셀">프레젠테이션/엑셀</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=워드/타이핑">워드/타이핑</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=교정/편집">교정/편집</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=기타문서작성">기타문서작성</a>
  	</c:if>
  	<c:if test="${Kinds eq '음악/영상'}">
   	<a class="dropdown-item" href="/talent/talent_S_list?n=음악/영상">전체보기</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=영상편집/제작">영상편집/제작</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=애니메이션/UCC">애니메이션/UCC</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=노래/댄스">노래/댄스</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=기타음악영상">기타음악영상</a>
  	</c:if>
  	<c:if test="${Kinds eq '프로그램개발'}">
  	<a class="dropdown-item" href="/talent/talent_S_list?n=프로그램개발">전체보기</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=홈페이지/웹개발">홈페이지/웹개발</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=응용프로그래밍(코딩)">응용프로그래밍(코딩)</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=모바일/앱">모바일/앱</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=DB/서버">DB/서버</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=기타프로그램개발">기타프로그램개발</a>
  	</c:if>
  	<c:if test="${Kinds eq '생활서비스'}">
  	<a class="dropdown-item" href="/talent/talent_S_list?n=생활서비스">전체보기</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=여행일정/계획">여행일정/계획</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=컴퓨터수리/조립">컴퓨터수리/조립</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=미용/스타일링">미용/스타일링</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=구매대행/직구">구매대행/직구</a>
  	<a class="dropdown-item" href="/talent/talent_S_list_2?n=기타생활서비스">기타생활서비스</a>
  	</c:if>

    <c:forEach items="${list}" var="list">
    <div class="card mb-4">
      <div class="card-body">
          <div class="col-lg-6">
            <h2 class="card-title"><label>제목 : </label>${list.tals_Title}</h2>
            <p class="card-text"><label>작성자 : </label>${list.tals_Id}</p>
            <p class="card-text"><label>재능1차분류 : </label>${list.tals_Kinds}</p>
            <p class="card-text"><label>재능2차분류 : </label>${list.tals_Kinds_2}</p>
            <p class="card-text"><label>가격 : </label><fmt:formatNumber value="${list.tals_Price}" pattern="###,###,###원"/></p>
            <p class="card-text"><div id="btn-place"><a href="/talent/talent_S_view?n=${list.tals_Code}"  class="btn btn-primary">상세보기 &rarr;</a></div> </p> 
          </div>
      </div>
    </div>
      	
    </c:forEach>
    </div>
    <!-- /.row -->


  
  <!-- /.container -->
<hr />

</div>

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">충대장터</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

</body>

</html>