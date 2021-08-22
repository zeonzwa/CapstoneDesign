<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
   <head>
  <meta charset="utf-8">

  <title>충대장터 회원가입</title>

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/join.css" rel="stylesheet" type="text/css">
  <script src="vendor/jquery/jquery.min.js"></script>
<script src="/resources/jquery/jquery-3.3.1.min.js"></script>  
<style>
#btnCen {
    width: 100%;
    padding: 21px 0 17px;
    border: 0;
    cursor: pointer;
    color: #fff;
    background-color: black;
    font-size: 20px;
    font-weight: 400;
    font-family: Dotum,'돋움',Helvetica,sans-serif;
}
</style>
    </head>
 
    <body>
        <div id="joinlogo">
        <h1 >
            <span>로고</span>                    
        </h1>
    </div>
        <!-- wrapper -->
        <div id="wrapper">

            <!-- content-->
            <div id="content">
			<form role="form" method="post" autocomplete="off" id="regForm">
                <!-- ID -->
                <div>
                    <h3 class="join_title">
                        <label for="Id">아이디</label>
                    </h3>
                    <span class="box int_id">
                        <input type="text" id="Id" name="Id" required="required" class="int">  
                    </span>
                    <span class="error_next_box"></span>
                     <button class="idChk" type="button">아이디 확인</button>
                     <p class ="result">
                     	<span class="msg">아이디를 확인해주십시오.</span>
                     </p>
                </div>

                <!-- PW1 -->
                <div>
                    <h3 class="join_title"><label for="Pw">비밀번호</label></h3>
                    <span class="box int_pass">
                        <input type="password" id="Pw" name="Pw" required="required" class="int">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- NAME -->
                <div>
                    <h3 class="join_title"><label for="Name">이름</label></h3>
                    <span class="box int_name">
                        <input type="text" id="Name" name="Name" placeholder="이름을 입력해주세요" class="int" required="required">
                    </span>
                    <span class="error_next_box"></span>
                </div>
                <!-- 전공 -->
                 <div>
                    <h3 class="join_title"><label for="Major">전공</label></h3>
                    <span class="box int_name">
                        <input type="text" id="Major" name="Major" placeholder="ex)컴퓨터공학과" class="int" required="required">
                    </span>
                    <span class="error_next_box"></span>
                </div>
                <!-- 학번 -->
                 <div>
                    <h3 class="join_title"><label for="Student_Num">학번</label></h3>
                    <span class="box int_name">
                        <input type="text" id="Student_Num" name="Student_Num" placeholder="ex)2021040001" class="int" required="required">
                    </span>
                    <span class="error_next_box"></span>
                </div>

                <!-- EMAIL -->
                <div class="int_email_area">
                    <h3 class="join_title"><label for="Email">이메일인증 때 입력했던 이메일을 다시 입력하세요.<span class="optional"></span></label></h3>
                    <span class="box int_email">
                        <input type="text" id="Email" name="Email" class="int" maxlength="100" placeholder="학교이메일을 입력해주세요" required="required">
                        <span class="step_url"></span>
                    </span>
                    <a href="#" class="btn_verify btn_primary" id="btnSend" role="button">
                        <span class="">인증메일 받기</span>
                    </a>
                    <span class="error_next_box">이메일 주소를 다시 확인해주세요.</span>    
                </div>

                <!-- MOBILE -->
                <div>
                    <h3 class="join_title"><label for="Phone_Num">휴대전화</label></h3>
                    <span class="box int_mobile">
                        <input type="text" id="Phone_Num" name="Phone_Num" placeholder="ex)010-1234-5678 (-포함)" required="required" class="int">
                    </span>
                    <span class="error_next_box"></span>    
                </div>



                <!-- JOIN BTN-->
                <div class="btn_area">
                    <button type="submit" id="btnJoin" name="signup_btn" disabled="disabled">가입하기</button>
                    
                    <button class="cencle" type="button" id ="btnCen">취소</button>
                </div>

                
			</form>
            </div> 
            <!-- content-->

        </div> 
        <!-- wrapper -->
    <script type="text/javascript">
  	  $(".cencle").on("click", function(){
		location.href = "/member/signin";
		});
      $(".idChk").click(function(){   	  
    	  
    	  var query = {Id : $("#Id").val()};
    	  $.ajax({
    	   url : "/member/idChk",
    	   type : "post",
    	   data : query,
    	   success : function(data) {
    	   
    	    if(data == 1) {
    	     $(".result .msg").text("사용 불가");
    	     $(".result .msg").attr("style", "color:#f00");
    	     $("#btnJoin").attr("disabled", "disabled");
    	    } else {
    	     $(".result .msg").text("사용 가능");
    	     $(".result .msg").attr("style", "color:#00f");
    	     $("#btnJoin").removeAttr("disabled");
    	    }
    	   }
    	  });  // ajax 끝
    	 });
      $("#Id").keyup(function(){
    	  $(".result .msg").text("아이디를 확인해주십시오.");
    	  $(".result .msg").attr("style", "color:#000");
    	  
    	  $("#btnJoin").attr("disabled", "disabled");
    	  
    	 });
    </script>
    </body>
</html>