<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
   <meta charset="UTF-8" />
   <title>로그인</title>
</head>
<body>
	<div id="join">
		<div class="joinTop">
			<h2>
				<p>join</p>
				<span>회원가입</span>
			</h2>
		</div>
		<div class="joinCenter">
			<form action="/member/joinFrom" method="get" name="joinForm">
				<fieldset class="joinField">
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
					
					<div class="input_row">
						<span class="input_box">
							<input type="name" id="name" placeholder="이름"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="addr" id="addr" placeholder="주소"/>
						</span>
					</div>
					<div class="input_row">
						<span class="input_box">
							<input type="birth" id="birth" placeholder="생년월일"/>
						</span>
					</div>
					
					<div class="input_button">
						<span class="input_box">
							<input type="button" id="joinButton" value ="회원가입"/>
						</span>
					</div>
					
				</fieldset>
			</form>
		</div>
	</div>
</body>
</html>