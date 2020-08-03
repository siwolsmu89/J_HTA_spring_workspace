<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<title>Navbar</title>
</head>
<body>
<!-- 
	!!!! 사용 전 필독 !!!!
	
	1. 실제 사용 시에는 <body> 태그로 감싸져 있는 안쪽 부분만 잘라내서 파일로 저장하고 include 해서 사용하시면 됩니다. 
	   지금은 부트스트랩이나 jquery 기본 함수들 작동하는거 보려고 html 태그로 감싸놓은 상태예요. 
	   
	2. 중간중간 padding-top, ml, pl 이런 간격 조정하는 클래스, 스타일 같은 것들이 들어가 있습니다.
	   그림 파일이 바뀌거나 다른 조정사항이 있으면 바뀌는거 보고 수동으로 간격 맞춰주셔야 합니다.
	   
	3. 메뉴 드랍박스 부분에서 로그인여부에 따라서 a태그 표시 바뀌는거 만들어주세요.
	
	4. 가운데 있는 col-5 div (아이디 : nav-div-searchbar) 부분은 'home.jsp에서는 $(function() { $("#nav-div-searchbar").hide(); }); 넣어서 감춰주세요.
	
	@Author 민석
-->
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
 <div class="d-flex justify-content-between w-100 row">
 <div class="col-3 pl-5">
  <a class="navbar-brand" href="#">
  	<img src="resources/level_1.png" alt="Logo" style="width:60px;">
  </a>
 </div>
  
 <div id="nav-div-searchbar" class="col-5">
  <form style="width: 100%; padding-top: 12px;" class="form-inline d-flex justify-content-center" action="#">
    <div class="input-group" style="width: 60%">
      <input type="text" class="form-control" placeholder="Search With Title">
      <div class="input-group-prepend">
        <button class="input-group-text btn btn-sm btn-primary">↲</button>
      </div>
    </div>
  </form>
 </div> 
 <div class="col-3 d-flex justify-content-end">
  <!-- Links -->
  <ul class="navbar-nav">
    <!-- Dropdown -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle pt-4" href="#" id="navbardrop" data-toggle="dropdown">
        MENU
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#">Community</a>
        <a class="dropdown-item" href="#">All List</a>
        <a class="dropdown-item" href="#">My List</a>
<!-- !!! 로그인 여부에 따라 바뀌는곳 여기 !!! -->
        <a class="dropdown-item" href="#">Log-in</a>
        <a class="dropdown-item" href="#">Log-out</a>
      </div>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#">
	  	<img class="pt-2" src="resources/level_1.png" alt="Logo" style="width:40px;">
	  </a>
    </li>
  </ul>
 </div> 

 </div>
</nav>
</body>
</html>