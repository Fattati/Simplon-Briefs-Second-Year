<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>articles management</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<%@include file="header.jsp" %>
<div class="container col-md-6	 col-md-offset-1">
<div class="panel panel-primary">
<div class="panel-heading">Search</div>
<div class="panel-body">	
<form action="search.do" method="get">
<label>article name</label>
<input type="text" name="name" value="${model.n }">
<button type="submit" class="btn btn-primary">search</button>
</form>
<table class="table table-striped">
<tr>
<th>ID</th><th>Name</th>
</tr>
<c:forEach items="${model.articles}" var="a" >
<tr>
<td>${a.id} </td>
<td>${a.name} </td>
<td><a href="delete.do?id=${a.id}">Delete</a></td>
<td><a href="edit.do?id=${a.id}">Edit</a></td>
</tr>
</c:forEach>
</table>
</div>
</div>
</div>
</body>
</html>