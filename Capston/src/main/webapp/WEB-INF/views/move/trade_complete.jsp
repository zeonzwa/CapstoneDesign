<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE jsp>
<jsp lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>충대장터 -거래완료(후기작성)</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
  
  <!--  add CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/web.css" rel="stylesheet" type="text/css">
  

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
              거래소
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
              <a class="dropdown-item" href="/admin/trade_list">판매</a>
              <a class="dropdown-item" href="/admin/goodsb_list">구매</a>
            </div>
          </li>
          <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              재능거래소
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="/move/uploaded">재능 판매</a>
              <a class="dropdown-item" href="/move/wantbuy">재능 구매</a>
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

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">마이 페이지
      <small></small>
    </h1>

    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">거래완료(후기작성)</a>
      </li>
      <li class="breadcrumb-item active">거래 완료된 물건</li>
    </ol>

    <!-- Blog Post -->
    <c:forEach items="${list}" var="list">
    <div class="card mb-4">
      <div class="card-body">
        <div class="row">
           <div class="col-lg-6">
            <a href="#">
              <img class="img-fluid rounded" src="${list.goods_Pic}" alt="">
            </a>
          </div>
          <div class="col-lg-6">
            <h2 class="card-title"><span>제목</span>${list.goods_Name}</h2>
            <p class="card-text"><span>판매자</span>${list.seller_Id}</p>
            <p class="card-text"><span>내용</span>${list.goods_Des}</p>                     
            <a href="/move/review_reg?n=${list.goods_Code}" class="btn btn-primary">후기 작성 &rarr;</a>
          </div>
        </div>
      </div>
      <div class="card-footer text-muted">
        <p>${list.phone_Num}</p>
        <a href="#"></a>
      </div>
    </div>
    </c:forEach>



    <!-- Pagination -->
    <ul class="pagination justify-content-center mb-4">
      <li class="page-item">
        <a class="page-link" href="#">&larr; Older</a>
      </li>
      <li class="page-item disabled">
        <a class="page-link" href="#">Newer &rarr;</a>
      </li>
    </ul>

  </div>
  <!-- /.container -->

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
</body>

</jsp>
