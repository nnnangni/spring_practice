<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script>
	function newsDelete(aid){
		if (confirm("선택하신 뉴스를 삭제하시겠습니까?")){
			//document.location.href="newsDelete.jsp?mode=delete&aid="+aid;
			document.location.href="/news/delete/"+aid; //@GetMapping("/delete/{aid}") 와 맵핑되게 하기위해
		}
	}
	
	function addNews(){
		var title = document.getElementById("title");
		var content = document.getElementById("content");
		if (title==null || title.value=="") {
			alert("제목을 입력하세요.");
			title.focus();
			return;
		}
		if (content==null || content.value=="") {
			alert("내용을 입력하세요.");
			content.focus();
			return;
		}
		document.frmAdd.submit();
	}
</script>
</head>
<body>
	<div class="container w-75 mt-5 mx-auto">
		<h2>뉴스목록</h2>
		<hr>
		<ul class="list-group">
			<%
				//while (rs.next()){
				//1. for (News news : newslist) {
					// 2. for (int idx=0; idx<newslist.size();idx++){
						// News news = newslist.get(idx);
				

			%>	
			<c:forEach var="news" items="${list}">
<!-- 					news -> News
					news.getAid() -> news.aid
					news.getTitle() -> news.title -->
					<li class="list-group-item d-flex justify-content-between">
						<a href="/news/${news.aid }">
							[${news.aid }] 
							${news.title }
							/${news.date }
						</a>
						<span class="button bg-secondary pull-right">
							<a href="#" onClick="javascript:newsDelete(${news.aid })">X</a>
						</span>
					</li>
			</c:forEach>							

		</ul>
		<hr>
		<div id="addForm" >
			<div class="card card-body">
			<!-- <form name="frmAdd" method="post" action="newsAdd.jsp" onSubmit="return javascript:addNews(this);"> -->
			<form name="frmAdd" method="post" action="/news/add">
				<input type=hidden name="mode" value="add">
				<label class="form-label">제목</label>
				<input type=text name="title" id="title" class="form-control">		
				<label  class="form-label">기사내용</label>		
				<textarea cols=50 rows=5 name="content" id="content" class="form-control"></textarea>
				<button type="button" class="btn btn-success" onClick="javascript:addNews()">저장</button>
			</form>
			</div>
		</div>	
	</div></body></html>
