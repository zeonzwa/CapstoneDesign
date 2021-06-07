<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>상품 등록</title>

  <!-- Bootstrap core CSS -->
  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="./about2.css">
  <link rel="stylesheet" href="./about3.css">
  
  
 <style>
 
 	section#container { padding:20px 0; border-top:2px solid #eee; border-bottom:2px solid #eee; }
	section#container::after { content:""; display:block; clear:both; }
	div#container_box { float:right; width:calc(100% - 200px - 20px); }
	div#wrapper {
    position: relative;
    height: 100%;
    }
</style>
 
<style>
.inputArea { margin:10px 0; }
select { width:100px; }
label { display:inline-block; width:90px; padding:5px; }
label[for='gdsDes'] { display:block; }
input { width:150px; }
textarea#gdsDes { width:400px; height:180px; }
.step_url {    position: absolute;    top: 16px;    right: 13px;    font-size: 15px;    color: #8e8e8e;}
.select_img img {margin:20px 0;}
#wrapper {
    position: relative;
    height: 100%;
}
#content {
    position: relative;
    left: 50%;
    transform: translate(-50%);
    width: 800px;
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
              <a class="dropdown-item" href="/talent/talent_S_list">재능 판매</a>
              <a class="dropdown-item" href="/talent/talent_B_list">재능 구매</a>
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

  

    <!-- Team Members -->
   <section id="container">
   
		<div id="wrapper"> 
<div id="content">
		
			    <h1 class="mt-4 mb-3">물품 등록
      <small></small>
    </h1>
			    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="index.html">거래소</a>
      </li>
      <li class="breadcrumb-item active">물품 등록</li>
    </ol>
				
<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">


<div class="inputArea">
	<label for="goods_Name">상품명</label>
	<input type="text" id="goods_Name" name="goods_Name"/>
</div>
<div class="inputArea">
	<label for="goods_Cate">상품분류</label>
	<select id="goods_Cate" name="goods_Cate" >
		<option value="서적" selected="selected">서적</option>
  		<option value="기계">기계</option>
 	 	<option value="옷" >옷</option>
	</select>
</div>

<div class="inputArea">
	<label for="goods_Price">상품가격</label>
	<input type="text" id="goods_Price" name="goods_Price" />
</div>
<div class="inputArea">
	<label for="goods_Sta">상품상태</label>
	<select id="goods_Sta" name="goods_Sta" >
		<option value=1 selected="selected">1(최하)</option>
  		<option value=2>2</option>
 	 	<option value=3>3</option>
 	 	<option value=4>4</option>
 	 	<option value=5>5(최상)</option>
	</select>
</div>

<div class="inputArea">
	<label for="goods_Des">상품소개</label>
	<textarea rows="5" cols="50" id="goods_Des" name="goods_Des"></textarea>
</div>
<div class="inputArea">
 <label for="goods_Pic">이미지</label>
 <input type="file" id="goods_Pic" name="file" />
 <div class="select_img"><img src="" /></div>
 
 <script>
  $("#goods_Pic").change(function(){
   if(this.files && this.files[0]) {
    var reader = new FileReader;
    reader.onload = function(data) {
     $(".select_img img").attr("src", data.target.result).width(500);        
    }
    reader.readAsDataURL(this.files[0]);
   }
  });
 </script>
 <%=request.getRealPath("/") %> 
</div>
<div class="inputArea">
	<button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
</div>
</div>
</div>
</form>
			
		</div>
	</section>

    <!-- /.row -->


  
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
