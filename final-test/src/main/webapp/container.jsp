<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title></title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<div class="header">
		<div class="row">
			<div class="col-12 bg-dark">
				<%@ include file="navbar.jsp" %>	
			</div>
		</div>
	</div>


	<div class="body">
		<div class="row" style="height: 100%;">
			<div class="col-3 d-flex justify-content-center bg-light">
				<%@ include file="sidebar.jsp" %>
			</div>
			<div class="col-9">
			
			</div>
		</div>
	</div>
</div>


</body>
</html>