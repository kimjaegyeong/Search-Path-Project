<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "project.test.DTO.Block" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/create_evacuation_map_css.css">
</head>
<body>
<%
		Block[][] blockMatrix = (Block[][])request.getAttribute("blockMatrix");
%>

<table>

<% for(Block[] dto: blockMatrix) {%>	
	
	<% for (Block dto2 : dto){ %>
		
		<button class="buttonBox" style="background-color: <%=dto2.getColor() +";"%>" value ="<%= dto2.getRoom() %>">
		 
	<% } %>
	<br>
<% } %>
</table>
</body>
</html>