<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Document</title>
</head>
<body>
	<h1>${name} 계좌정보 보기</h1>
	<div>
		<!-- 테이블 만드는 단축키 : table>tr+2>td+4 -->
		<table style="width:800px;height:100px;border:1px solid black">
			<tr style="width:800px;height:50px;border:1px solid black">
				<td style="width:50px;border:1px solid black">번호</td>
				<td style="width:150px;border:1px solid black">아이디</td>
				<td style="width:200px;border:1px solid black">이름</td>
				<td style="width:400px;border:1px solid black">계좌번호</td>
			</tr>
			<tr style="width:800px;height:50px;border:1px solid black">
				<td style="width:50px;border:1px solid black"></td>
				<td style="width:150px;border:1px solid black"></td>
				<td style="width:200px;border:1px solid black"></td>
				<td style="width:400px;border:1px solid black"></td>
			</tr>
		</table>
		
	</div>
	<div><a href="${context}/member/detail">회원정보보기</a></div>
</body>
</html>