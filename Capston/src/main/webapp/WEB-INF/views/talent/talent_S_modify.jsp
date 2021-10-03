<%@ page session="false" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Modern Business - Start Bootstrap Template</title>

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
.select_img img {width:418px; height:250px;}
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
<script language = "javascript">
function categoryChange(e) {
	var talent_1 = ["웹디자인/상세페이지", "포토샵편집", "일러스트/캐릭터", "3D모델링/도면", "기타디자인"];
	var talent_2 = ["영어", "중국어", "일본어", "한자", "기타외국어"];
	var talent_3 = ["프로젠테이션/엑셀", "워드/타이핑", "교정/편집", "기타문서작성"];
	var talent_4 = ["영상편집/제작", "애니메이션/UCC", "노래/댄스", "기타음악영상"];
	var talent_5 = ["홈페이지/웹개발", "응용프로그래밍(코딩)", "모바일/앱", "DB/서버", "기타프로그램개발"];
	var talent_6 = ["여행일정/계획", "컴퓨터수리/조립", "미용/스타일링", "구매대행/직구", "기타생활서비스"];
	var target = document.getElementById("tals_Kinds_2");
	
	if(e.value == "디자인") var a = talent_1;
	else if(e.value == "번역/외국어") var a = talent_2;
	else if(e.value == "문서작성") var a = talent_3;
	else if(e.value == "음악/영상") var a = talent_4;
	else if(e.value == "프로그램개발") var a = talent_5;
	else if(e.value == "생활서비스") var a = talent_6;
	
	target.options.length = 0;
	
	for(x in a){
		var opt = document.createElement("option");
		opt.value = a[x];
		opt.innerHTML = a[x];
		target.appendChild(opt);
	}
}
</script>
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
  
    <!-- Talent_S Members -->
    <section id="container">
   
		<div id="wrapper"> 
<div id="content">
		
			    <h1 class="mt-4 mb-3">재능판매 수정
      <small></small>
    </h1>
			    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <a href="/talent/talent_S_list">재능판매</a>
      </li>
      <li class="breadcrumb-item active">재능판매 수정</li>
    </ol>
			
<form role="form" method="post" autocomplete="off" enctype="multipart/form-data">

<input type="hidden" name="tals_Code" value="${talent.tals_Code}" />


<div class="inputArea">
 <label for="tals_Title">제목</label>
 <input type="text" id="tals_Title" name="tals_Title" value="${talent.tals_Title}"/>
</div>
<div class="inputArea">
	<label for="tals_Kinds">재능분류</label>
	<select id="tals_Kinds" name="tals_Kinds" onchange="categoryChange(this)">
		<option>재능을 선택해주세요</option>
		<option value="디자인">디자인</option>
		<option value="번역/외국어">번역/외국어</option>
		<option value="문서작성">문서작성</option>
		<option value="음악/영상">음악/영상</option>
		<option value="프로그램개발">프로그램개발</option>
		<option value="생활서비스">생활서비스</option>
	</select>
	<select id="tals_Kinds_2" name ="tals_Kinds_2">
	<option>세부 재능 선택</option> 	
	</select>
</div>
<div class="inputArea">
 <label for="tals_Content">내용</label>
 <textarea rows="5" cols="50" id="tals_Content" name="tals_Content">${talent.tals_Content}</textarea>
</div>
<div class="inputArea">
 <label for="tals_Price">가격</label>
 <input type="text" id="tals_Price" name="tals_Price" value="${talent.tals_Price}"/>
</div>
<div class="inputArea">
 <label for="tals_Term">작업 기간</label>
 <input type="text" id="tals_Term" name="tals_Term" value="${talent.tals_Term}"/>
</div>

<div class="inputArea">
 <button type="submit" id="update_Btn" class="btn btn-primary">완료</button>
 <button type="submit" id="back_Btn" class="btn btn-warning">취소</button>
  <script>
 $("#back_Btn").click(function(){
  //history.back();
  location.href = "/talent/talent_S_view?n=" + ${talent.tals_Code};
 });   
</script>
</div>   

</form>
			
		</div>
	</section>
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