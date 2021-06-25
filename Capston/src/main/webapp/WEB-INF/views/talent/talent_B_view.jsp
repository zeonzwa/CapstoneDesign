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

  <title>Modern Business - Start Bootstrap Template</title>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">

<style>
.inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:200px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
.gdsDes { marigin:10px 0;width:400px; height:180px; }
.card-img-top{width:418px; height:250px; }
.star{background-image:url(/resources/image/star.jpg);}
.thumbImg {}
#com_Btn {border : 0; width:100px; height:30px;;  position: relative; left:70%;}
#rej_Btn {border : 0; width:100px; height:30px;;  position: relative; left:70%;}
#cancel_Btn {border : 0; width:100px; height:30px;;  position: relative; left:70%;}
#req_Btn {border : 0; width:100px; height:30px;;  position: relative; left:70%;}
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

  <!-- Page Content -->
  <div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">재능구매 상세</h1>

	<form role="form" method="post" autocomplete="off">
			
	<input type="hidden" name="n" value="${talent.talb_Code}"/>

    <!-- Intro Content -->
    <div class="row">
      <div class="col-lg-6">
        <div class="inputArea">
				<label for="gdsName">제목</label>
				<span>${talent.talb_Title}</span>
		</div>
		<div class="inputArea">
				<label for="gdsCategory">구매희망분류</label>
				<span>${talent.talb_Kinds}</span>
		</div>
		 <div class="inputArea">
				<label>작성자</label>
				<span>${talent.talb_Id}</span>
		</div>
		<div class="inputArea">
				<label for="gdsCategory">연락처</label>
				<span>${talent.phone_Num}</span>
		</div>
        <div class="inputArea">
				<label for="gdsDes">내용</label>	
				<div class="gdsDes">${talent.talb_Content}</div>
			</div>
      </div>
    </div>

    <!-- /.row -->
  </div>
  <c:choose>
  <c:when test = "${member.id eq talent.talb_Id}">
  <div id = "tradebtn">
    <button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
	<button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>
			<script>
					var formObj = $("form[role='form']");
					
					$("#modify_Btn").click(function(){
						formObj.attr("action", "/talent/talent_B_modify");
						formObj.attr("method", "get")
						formObj.submit();
					});
					
					$("#delete_Btn").click(function(){
						
						var con = confirm("정말로 삭제하시겠습니까?");
						
						if(con) {						
							formObj.attr("action", "/talent/talent_B_delete");
							formObj.submit();
						}
					});
				</script>	
  </div>

</c:when>
<c:otherwise>

</c:otherwise>

</c:choose>


   
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

</html>
