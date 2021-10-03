<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Modern Business - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
  <style>
  * {
    margin: 0;
    padding: 0;
}



body {
    font: 17px 'Nanum Gothic', sans-serif;
}



a {
    text-decoration: none;
    color: #404040;
}



li {
    list-style: none;
}



/*BODY*/

#notice {
    width: 100%;
    margin: 0 auto;
    box-sizing: border-box;
    /*outline: 1px dashed black;*/
}



#notice h1 {
    font-size: 25px;
    text-align: center;
    margin: 10px 180px;
    padding: 10px;
    color: #fff;
    background: #007AAE;
    border-radius: 30px;

}



#notice ul {
    width: 100%;
}



#notice ul li {
    line-height: 30px; /*li 세로 간격*/
    padding-left: 20px;
}



#notice ul li:first-child {
    border-top: 2px solid #6a6a6a;
    border-bottom: 2px solid #6a6a6a;
    padding-left: 150px;
}



#notice ul li:last-child {
    border-bottom: 1px solid #000;
}






#notice ul li span {
    display: inline-block;
    float: right;
    width: 150px;
    text-align: center;
}


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
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              중고장터
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
              <a class="dropdown-item" href="/admin/trade_list">중고판매</a>
              <a class="dropdown-item" href="/admin/goodsb_list">중고구매</a>
            </div>
          </li>
          <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              재능장터
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="/talent/talent_S_list">재능판매</a>
              <a class="dropdown-item" href="/talent/talent_B_list">재능구매</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              마이페이지
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="/move/uploaded">내가 등록한 물건</a>
              <a class="dropdown-item" href="/move/wantbuy">내가 요청한 물건</a>
              <a class="dropdown-item" href="/move/review">후기관리</a>
              <a class="dropdown-item" href="/move/trade_complete">거래완료(후기작성)</a>
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

<div class="search">
 <select name="searchType">
  <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
  <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
  <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
 </select>
 
 <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>

 <button id="searchBtn">검색</button>
 
 <script>
 $(function(){
  $('#searchBtn').click(function() {
   self.location = "contactlistSearch"
     + '${pageMaker.makeQuery(1)}'
     + "&searchType="
     + $("select option:selected").val()
     + "&keyword="
     + encodeURIComponent($('#keywordInput').val());
    });
 });   
 </script>
</div>

  <!-- Page Content -->
  <div class="container">
      <!-- Page Heading/Breadcrumbs -->
    <h3 id="notice_list_title" class="mt-4 mb-3">관리자 게시판
    <button id = "reg" onclick="location.href='/move/manager_register'">등록</button>
    <a href="/move/contact_member">회원관리</a><br>
    <a href="/move/manager_talent_S">재능판매관리</a><br>
    <a href="/move/manager_sell">물품판매관리</a><br>
    <a href="/move/manager_faq">1:1문의관리</a><br>
      <small></small>
    </h3>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">공지사항</a>
      </li>
      <li class="breadcrumb-item active">공지사항 목록</li>
    </ol>


<c:forEach items="${list}" var="list">
	<div class="card mb-4">
	 <div class="card-body">
	  <div class="row">
	   <div class="col-lg-6">
	    <p class="card-text"><label>글 번호 :</label>${list.notice_Num}</p>
	    <p class="card-text"><label>글 제목 :</label>${list.notice_Title}</p>
	    <p class="card-text"><label>글 내용 :</label>${list.notice_Content}</p>
	    <p class="card-text"><div id="btn-place"><a href="/move/manager_view?n=${list.notice_Num}"  class="btn btn-primary">상세보기 &rarr;</a></div> </p>
	   </div>
	  </div>
	 </div>
	</div>
</c:forEach>

  <c:choose>
  <c:when test = "${notice.id=='manager'}">
  <div id = "tradebtn">
    <button id = "reg" onclick="location.href='/move/contact_register'">등록</button>
    <a href="/move/contact_member">회원관리</a>
  </div>

</c:when>
<c:otherwise>

</c:otherwise>

</c:choose>


    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
<div>
 <ul>
  <c:if test="${pageMaker.prev}">
   <li><a href="managerlistPage${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
  </c:if> 
  
  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
   <li><a href="managerlistPage${pageMaker.makeQuery(idx)}">${idx}</a></li>
  </c:forEach>
    
  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
   <li><a href="managerlistPage${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
  </c:if> 
 </ul>
</div>
  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">충대 장터</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
  <script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>


  <!-- Contact form JavaScript -->
  <!-- Do not edit these files! In order to set the email address and subject line for the contact form go to the bin/contact_me.php file. -->
  <script src="js/jqBootstrapValidation.js"></script>
  <script src="js/contact_me.js"></script>

</body>

</html>
