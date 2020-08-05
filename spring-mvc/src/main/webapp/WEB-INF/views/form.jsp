<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
	<title>쇼핑몰</title>
</head>
<body>
	<div class="container mt-3 mb-5">
		<div class="row">
			<div class="col-12">
				<div class="card">
					<form id="user-form" method="post" action="signup.do">
						<div class="card-header">회원 가입 폼</div>
						<div class="card-body">
							<div class="form-group">
								<label>아이디</label>
								<input class="form-control" type="text" name="id" id="user-id" />
							</div>
							<div class="form-group">
								<label>이름</label>
								<input class="form-control" type="text" name="name" id="user-name" />
							</div>
							<div class="form-group">
								<label>비밀번호</label>
								<input class="form-control" type="password" name="password" id="user-password" />
							</div>
							<div class="form-group">
								<label>이메일</label>
								<input class="form-control" type="text" name="email" id="user-email" />
							</div>
							<div class="form-group">
								<label>전화번호</label>
								<input class="form-control" type="text" name="tel" id="user-tel" />
							</div>
							<div class="form-group">
								<label>나이</label>
								<input class="form-control" type="number" name="age" id="user-age" />
							</div>
							<div class="form-group">
								<label>생일</label>
								<input class="form-control" type="date" name="birth" id="user-birth" />
							</div>
						</div>
						<div class="card-footer text-right">
							<button class="btn btn-success">등록</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>