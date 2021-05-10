<%@ page session="false" pageEncoding="utf-8" %>

<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
    <title>충대장터</title>
    <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="./login.css">

</head>
<body>
    <div id="login-center">

        <h2 >
            <span>로그인</span>
        </h2>
        <h1>
            <span>충대 장터</span>
        </h1>
        <h1>Login</h1>
        <div class="idForm">
            <input type = "text" class = "id" placeholder="ID">
        </div>
        <div class="pwdForm">
            <input type="password" class ="pw" placeholder="PW">
        </div> 
        <button type="button" class = "btn" onclick="button()">
        Log In
        </button>
        <div class="join">
           아이디가 없으신가요? <a href="#">회원 등록 </a>
            </div>
    </div>
</body>