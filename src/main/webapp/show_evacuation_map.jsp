<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "project.test.DTO.Block" %>   
<!DOCTYPE html>
<html>
<head>
<!-- 해당 페이지를 새로고침 하면 이전 서블릿인 create_evacuation_map_servlet이 다시 가동되어 데이터베이스에 중복의 데이터가 저장됨. 문제 해결 요  -->
<meta charset="UTF-8">
<title>evacuation map display</title>
<link type="text/css" rel="stylesheet" href="css/create_evacuation_map_css.css">
</head>
<body>

<input type= "text" name="MatrixSize" value=25 readonly="readonly">
<br>
<br><%
		Block[]block = (Block[])request.getAttribute("block");
%>

<table>
<% int count =0 ; %>
<% for(Block dto: block) {%>	
		<button class="buttonBox" style="background-color: <%=dto.getColor() +";"%>" value ="<%= dto.getRoom() %>"><%= dto.getRoom() %></button>
		<% count++; %>
	<% if(count % 5 == 0 ){ %> <br> <% }%>
		
	<% } %>

</table>
<br>
</body>
</html>