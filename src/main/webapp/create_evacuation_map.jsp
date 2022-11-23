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
<script type="text/javascript" class="textBox" src="js/inputText_gathering.js"></script>

<form action="create_evaucation_map" name="submitButton" method="get">
<% int count =0; %>
<input type= "text" name="MatrixSize" value=25 readonly="readonly">
<br>
<br>
<% for(int i=0; i<5; i++) {%>	
	
	<% for (int j=0; j<5; j++){ %>
		<input type="text" class = "textBox" name="number<%= count %>" id="number<%= count %>">
		<% count++; %>
	<% } %>
	<br>
<% } %>
<br>
<div><input type=submit value="전송" style="margin-left:230px;"></div>
</form>
</body>
</html>