<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="UTF-8" />
   <title>로그인</title>
</head>
<body>
	<div id="login">
		<div class="loginTop">
			<h2>
				<p>LOGIN</p>
				<span>로그인</span>
			</h2>
		</div>
		<div class="loginCenter">
			<form action="/member/login" method="get" name="loginForm">
				<fieldset class="loginField">
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="userid" placeholder="아이디"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="password" id="password" placeholder="비밀번호"/>
						</span>
					</div>
					<div class="input_button">
						<span class="input_box">
							<input type="button" id="loginButton" value ="로그인"/>
						</span>
					</div>
					
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>