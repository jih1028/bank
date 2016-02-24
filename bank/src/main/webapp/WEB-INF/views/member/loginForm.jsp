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
			<form action="${context}/member/login" method="get" name="loginForm">
				<fieldset class="loginField">
					<div class="input_row">
						<span class="input_box">
							<input type="text" id="userid" name="userid" placeholder="아이디"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="password" id="password" name ="password" placeholder="비밀번호"/>
						</span>
					</div>
					<div class="input_button">
						<span class="input_box">
							<input type="button" id="loginButton" value ="로그인" onclick="login()"/>
						</span>
					</div>
					
				</fieldset>
				<div>
					<div>아이디가 없다면 회원가입 바랍니다.</div>
					<a href="${context}/member/joinForm">회원가입 바로가기</a>
				</div>
				
				
			</form>
		</div>
	</div>
	<script type="text/javascript">
		function login(){

			if (document.loginForm.userid.value=='') {
				alert('아이디를 입력해 주세요');
				document.loginForm.userid.focus();
			} else {
				if (document.loginForm.password.value=='') {
					alert('비밀번호를 입력해 주세요');
					document.loginForm.password.focus();
				}
				else{
					document.loginForm.submit();
					return true;
				}
			}
			
		}
	</script>
	
	
</body>
</html>