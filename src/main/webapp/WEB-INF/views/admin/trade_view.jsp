<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Modern Business - Start Bootstrap Template</title>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="./about2.css">
  <link rel="stylesheet" href="./about3.css">

<style>
.inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:70px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
.gdsDes { marigin:10px 0;width:400px; height:180px; }
.card-img-top{width:418px; height:250px; }
.thumbImg {}
</style>

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="index.html">Start Bootstrap</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="about.html">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="services.html">Services</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.html">Contact</a>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Portfolio
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
              <a class="dropdown-item" href="portfolio-1-col.html">1 Column Portfolio</a>
              <a class="dropdown-item" href="portfolio-2-col.html">2 Column Portfolio</a>
              <a class="dropdown-item" href="portfolio-3-col.html">3 Column Portfolio</a>
              <a class="dropdown-item" href="portfolio-4-col.html">4 Column Portfolio</a>
              <a class="dropdown-item" href="portfolio-item.html">Single Portfolio Item</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Blog
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item" href="blog-home-1.html">Blog Home 1</a>
              <a class="dropdown-item" href="blog-home-2.html">Blog Home 2</a>
              <a class="dropdown-item" href="blog-post.html">Blog Post</a>
            </div>
          </li>
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPages" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Other Pages
            </a>
            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPages">
              <a class="dropdown-item" href="full-width.html">Full Width Page</a>
              <a class="dropdown-item" href="sidebar.html">Sidebar Page</a>
              <a class="dropdown-item" href="faq.html">FAQ</a>
              <a class="dropdown-item" href="404.html">404</a>
              <a class="dropdown-item" href="pricing.html">Pricing Table</a>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">물품
      <small>상세</small>
    </h1>

	<form role="form" method="post" autocomplete="off">
			
	<input type="hidden" name="n" value="${goods.gdsNum}"/>

    <!-- Intro Content -->
    <div class="row">
      <div class="col-lg-6">
        <img class="card-img-top" src="${goods.gdsImg}">
      </div>
      <div class="col-lg-6">
        <div class="inputArea">
				<label for="gdsName">상품명</label>
				<span>${goods.gdsName}</span>
			</div>
		<div class="inputArea">
				<label for="gdsPrice">가격</label>
				<span><fmt:formatNumber value="${goods.gdsPrice}" pattern="###,###,###"/></span>
			</div>
		<div class="inputArea">
				<label for="gdsSta">상태</label>
				<span>${goods.gdsSta}</span>
			</div>	
        <div class="inputArea">
				<label for="gdsDes">소개</label>	
				<div class="gdsDes">${goods.gdsDes}</div>
			</div>
      </div>
    </div>

    <!-- /.row -->


  </div>
  <div id = "tradebtn">
    <button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
	<button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>
			<script>
					var formObj = $("form[role='form']");
					
					$("#modify_Btn").click(function(){
						formObj.attr("action", "/admin/modify");
						formObj.attr("method", "get")
						formObj.submit();
					});
					
					$("#delete_Btn").click(function(){
						
						var con = confirm("정말로 삭제하시겠습니까?");
						
						if(con) {						
							formObj.attr("action", "/admin/delete");
							formObj.submit();
						}
					});
				</script>	
  </div>

  <div id = "after">
    <h4>최근 거래 후기</h2>
    <ul>
      <li>정말 친절해요<h1><span id="star"></span></h1></li>
      <li>쿨거래 감사합니다<h1><span id="star"></span></h1></li>
      <li>후기3<h1><span id="star"></span></h1></li>
    </ul>
  </div>

   
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
