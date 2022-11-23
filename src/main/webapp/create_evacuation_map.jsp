<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>create_evaucation_map</title>
<link type="text/css" rel="stylesheet" href="css/create_evacuation_map_css.css">
</head>
<body>
<script type="text/javascript" src="js/inputText_gathering.js"></script>
<form action="js/inputText_gathering.js" name="submitButton" method="get">
<% int count =0; %>

<% for(int i=0; i<5; i++) {%>	
	
	<% for (int j=0; j<5; j++){ %>
		<input type="text" class = "textBox" name="number<%= count %>" id="number<%= count %>">
		<% count++; %>
	<% } %>
	<br>
<% } %>

<button  onClick= "gathering()">전송</button>
</form>
</body>
</html>