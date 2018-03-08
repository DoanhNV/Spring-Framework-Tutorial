<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=request.getContextPath() %></title>
</head>
<body>
	<sform:form action="${pageContext.request.contextPath}/user/create" method="POST"  modelAttribute="createUser">
		User name: <sform:input path="userName" id="txtuserName"/>
		<sform:errors path="userName"/><br>
		Password: <sform:password path="password" title="Password" id="txtPassowrd"/>
		<sform:errors path="password"/><br>
		<input type="button" value="Login" id="btnLogin">
	</sform:form>
	<a href="<%=request.getContextPath() %>">go to  root</a>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnLogin").click(function() {
				var userName = "userName=" + $("#txtuserName").val();
				var password = "&password" + $("#txtPassword").val();
				var data = userName + password;
				$.ajax({
					type: "POST",
					data: data,
					url: "${pageContext.request.contextPath}/user/create",
					success: function(response) {
						alert("sccuess!");
						var errors = JSON.parse(response);
						if(errors.length != 0) {
							for( var i = 0; i < errors.length; i++) {
								alert(errors[i].field + " - " + errors[i].message);
							}
						}
					},
					error: function(response) {
						alert("fail");
					}
				});
			});
		});
	</script>
</body>
</html>