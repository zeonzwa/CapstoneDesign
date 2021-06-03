<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
  <title>충대장터</title>
  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/market.css" rel="stylesheet" type="text/css">


</head>
<body>
    <div id="login-center">
    <form role="form" method="post" action="/member/signin" autocomplete="off">
        <h2 >
            <span>로그인</span>
        </h2>
        <h1>
            <span>충대 장터</span>
        </h1>
        <h1>Login</h1>
        <div class="idForm">
         <label for="Id">아이디</label><br>
  		 <input type="text" id="Id" name="Id" required="required" />            
        </div>
        <div class="pwdForm">
           <label for="Pw">패스워드</label>
  		 <input type="password" id="Pw" name="Pw" required="required" />   
        </div> 
        <button type="submit" class="btn" name="btn btn-primary">Log In</button>
		<p style="color:#f00;">${msg}</p>
		 </form>
        <div class="join">
        	<span>아이디가 아직 없으신가요?</span>
          	 <a href="/member/signup">회원가입</a>
         </div>
         </form>
  </div>
</body>
</html>