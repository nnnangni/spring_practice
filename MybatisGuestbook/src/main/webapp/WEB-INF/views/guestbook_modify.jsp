<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

</head>
<body>
<div class="container">
	<h3> 방명록 수정</h3>
	<hr>
<!-- 방명록 작성영역 -->
	<div id="addform">
		<!--  <form action="guestbook_update.jsp" method="post"> -->
		<form action="/update" method="post">
			
		<input type="hidden" name="seq" value="${guestbook.seq }">
		<table class="table">
			<tr>
				<th> 이름</th>
				<td><input type=text name="username" id="username" value="${guestbook.username }" class="form-control" ></td>
			</tr>
			<tr>
				<th> 제목</th>
				<td><input type=text name="title" id="title"  value="${guestbook.title } %>" class="form-control" ></td>
			</tr>
			<tr>
				<th> 내용</th>
				<td><textarea name="content" id="content" class="form-control"> ${guestbook.content }</textarea>
				
				</td>
			</tr>
			<tr>			
				<td colspan=2>
					<input type=submit class="btn btn-success"  value="수정하기">
				</td>
			</tr>
		</table>
		</form>
	</div>
</div>
</body>
</html>