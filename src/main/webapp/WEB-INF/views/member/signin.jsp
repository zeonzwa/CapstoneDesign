<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<section id="content">
	<form role="form" method="post" autocomplete="off">
		<div class="input_area">
			<label for="id">아이디</label>
			<input type="text" id="id" name="id" required="required" value="id" />						
		</div>
		
		<div class="input_area">
			<label for="pw">패스워드</label>
			<input type="password" id="pw" name="pw" required="required" value="1234" />						
		</div>
							
		<button type="submit" id="signin_btn" name="signin_btn">로그인</button>
		
		<c:if test="${msg == false}">
			<p style="color:#f00;">로그인에 실패했습니다.</p>
		</c:if>
		
	</form>			
</section>

</body>
</html>