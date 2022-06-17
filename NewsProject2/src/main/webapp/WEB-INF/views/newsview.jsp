<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">


</head>
<body>
<div class="container w-75 mt-5 mx-auto">
    <h2>${dto.title}</h2>
    <hr>
    <div class="card w-75 mx-auto">
        
       <div class="card-body">
          <h4 class="card-title">${dto.date}</h4>
          <p class="card-text">${dto.content}</p>
       </div>
    </div>
    <hr>
    <a href="javascript:history.back()" class="btn btn-primary"><< Back</a>
    
    </div>
    </body>
</html>