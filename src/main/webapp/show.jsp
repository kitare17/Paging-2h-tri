<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h2{
color: red;
text-align: center;
}
table, td, th {
	border: 1px solid;
text-align: center;
}
tr:nth-child(even) {
  background-color: #f2f2f2;
}
table{
width:50%;
}
div{

display: flex;
justify-content: center;
margin:30px;
}
.tableUser{
display: flex;
justify-content: center;
}
.page{
font-size: 20px;
background-color: gray;

}


a{
background-color :#f2f2f2;
padding: 10px;
margin:10px;
}
</style>
</head>
<body>
	<h2>List User</h2>
	<div class="tableUser">
	
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
		</tr>
		<c:forEach var="i" items="${subList}">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
			</tr>
		</c:forEach>

	</table>
	</div>
	
	<div class="page">
	<a href="list?page=first">First</a>
	<c:choose>
		<c:when test="${page<=3}">
			<c:forEach var="i" begin="1" end="5">
				<a href="list?page=${i}">${i}</a>
			</c:forEach>

		</c:when>
		<c:when test="${page>=maxPage-2}">
			<c:forEach var="i" begin="${maxPage-4}" end="${maxPage}">
				<a href="list?page=${i}">${i}</a>
			</c:forEach>
		</c:when>
		<c:otherwise>
		<c:forEach var="i" begin="${page-2}" end="${page+2}">
				<a href="list?page=${i}">${i}</a>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<a href="list?page=last">last</a>
	</div>
</body>
</html>