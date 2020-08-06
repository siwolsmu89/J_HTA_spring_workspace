<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
					<form:form id="user-form" method="post" action="signup.do" modelAttribute="userForm">
						<div class="card-header">회원 가입 폼</div>
						<div class="card-body">
							<div class="form-group">
								<label>아이디</label>
								<form:input class="form-control" type="text" path="id" id="user-id" />
								<form:errors path="id" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group">
								<label>이름</label>
								<form:input class="form-control" type="text" path="name" id="user-name" />
								<form:errors path="name" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group">
								<label>비밀번호</label>
								<form:input class="form-control" type="password" path="password" id="user-password" />
								<form:errors path="password" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group">
								<label>이메일</label>
								<form:input class="form-control" type="text" path="email" id="user-email" />
								<form:errors path="email" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group">
								<label>전화번호</label>
								<form:input class="form-control" type="text" path="tel" id="user-tel" />
								<form:errors path="tel" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group">
								<label>나이</label>
								<form:input class="form-control" type="number" path="age" id="user-age" />
								<form:errors path="age" cssClass="text-danger"></form:errors>
							</div>
							<div class="form-group">
								<label>생일</label>
								<form:input class="form-control" type="date" path="birth" id="user-birth" />
								<form:errors path="birth" cssClass="text-danger"></form:errors>
							</div>
						</div>
						<div class="card-footer text-right">
							<a href="/home.do" class="btn btn-secondary" >취소</a>
							<button type="submit" class="btn btn-success">등록</button>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>