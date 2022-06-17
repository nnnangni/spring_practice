<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<script>
		function deleteGuest(seq){
			if(confirm('선택하신 글을 삭제하시겠습니까?')){
				//document.location.href="guestbook_delete.jsp?seq="+seq;
				document.location.href="delete/"+seq;
			}
		}
		function modifyGuest(seq){
			if(confirm('선택하신 글을 수정하시겠습니까?')){
				document.location.href="modify/"+seq;
			}
		}
	</script>
	<style> 
		#delete {
		  background-color: red;
		  border: none;
		  color: white;
		  margin: 0 2px;
		}
		#update {
		  background-color: green;
		  border: none;
		  color: white;
		  margin: 0 2px;
		}		
	</style>
</head>
<body>
<div class="container">
	<h3> 방명록</h3>
	<hr>
<!-- 방명록 작성영역 -->
	<div id="addform">
		<!--  <form action="guestbook_add.jsp" method="post">  -->
		<form action="/add" method="post">
			<!--<input type="hidden" name="mode" value="add">-->
			<table class="table">
				<tr>
					<th> 이름</th>
					<td><input type=text name="username" id="username" class="form-control" ></td>
				</tr>
				<tr>
					<th> 제목</th>
					<td><input type=text name="title" id="title" class="form-control" ></td>
				</tr>
				<tr>
					<th> 내용</th>
					<td><textarea name="content" id="content" class="form-control"></textarea>
					
					</td>
				</tr>
				<tr>			
					<td colspan=2>
						<input type=submit class="btn btn-primary"  style="float:right" value="등록하기">
					</td>
				</tr>
			</table>
		</form>
	</div>

<!-- 방명록 목록 영역-->
	<c:forEach items="${list }" var="guestbook">
		<table class="table">
			<tr>
				<th>No.${guestbook.seq }</th>
				<th>${guestbook.title }</th>
				<td style="text-align:right;">${guestbook.regdate }</td>
			</tr>
			<tr>
				<td colspan=3>${guestbook.content }</td>
			</tr>
			<tr>
				<td colspan=3>
					글쓴이 : ${guestbook.username }
					
					<input type=button class="btn btn-alert mt-5"  style="float:right" id="delete" onClick="deleteGuest(${guestbook.seq });" value="삭제하기">
					<input type=button class="btn btn-normal mt-5" style="float:right" name="update" onClick="modifyGuest(${guestbook.seq });" value="수정하기">
				
				</td>
				
			</tr>
		</table>	
	</c:forEach>
	<br>
	

</div>
</body>
</html>