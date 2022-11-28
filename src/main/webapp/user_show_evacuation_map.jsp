<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "project.test.DTO.Block" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>evacuation map display</title>

<link type="text/css" rel="stylesheet" href="css/create_evacuation_map_css.css">
<script>
var btn = document.getElementsByClassName("buttonBox");

function handleClick(event) {
  console.log(event.target);
  // console.log(this);
  // 콘솔창을 보면 둘다 동일한 값이 나온다

  console.log(event.target.classList);

  if (event.target.classList[1] === "clicked") {
    event.target.classList.remove("clicked");
  } else {
    for (var i = 0; i < btn.length; i++) {
      btn[i].classList.remove("clicked");
    }

    event.target.classList.add("clicked");
  }
}

function init() {
  for (var i = 0; i < btn.length; i++) {
    btn[i].addEventListener("click", handleClick);
  }
}

init();
</script>

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
		<button class="buttonBox" style="background-color: <%=dto.getColor() +";"%>" ><%= (dto.getRoom().equals("path")) ? "_" :dto.getRoom()  %></button>
		<% count++; %>
	<% if(count % 5 == 0 ){ %> <br> <% }%>
	<% } %>

</table>
<br>
</body>
</html>