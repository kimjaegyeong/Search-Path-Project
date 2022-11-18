<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "project.test.DTO.Block" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		Block[][] blockMatrix = (Block[][])request.getAttribute("blockMatrix");
%>

<table>

<% for(Block[] dto: blockMatrix) {%>	
	
	<% for (Block dto2 : dto){ %>
		<button style= "width:90px; height:90px; border: 0; background-color: <%=dto2.getColor() +";"%>"><%= dto2.getRoom() %></button>
	<% } %>
	<br>
<% } %>
</table>
</body>
</html>