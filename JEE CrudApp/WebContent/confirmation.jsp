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
<div class="container col-md-6	 col-md-offset-1 col-xs-12">
<div class="panel panel-primary">
<div class="panel-heading">Details</div>
<div class="panel-body">	
<div class="form-group">
<label>ID:</label>
<label>${article.id }</label>
</div>
<div class="form-group">
<label>Article name:</label>
<label>${article.name }</label>
</div>
</div>
</div>
</div>
</body>
</html>