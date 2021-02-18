<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
<style><%@include file="css/products.css"%></style>


</head>

<body>
 <div class="navbar navbar-default" >
<ul class="nav navbar-nav">
<li><a  class="float-right" href="logout">Logout</a></li>
</ul>
</div>
<div class="container">
<div class="col-xs-12 col-md-6">
 <c:forEach items="${product}" var="p" varStatus="status">
	<!-- First product box start here-->
	<div class="prod-info-main prod-wrap clearfix">
		<div class="row">
				<div class="col-md-5 col-sm-12 col-xs-12">
					<div class="product-image"> 
						<img src="data:img/*;base64,${img[status.index]}" class="img-responsive"> 
						 
					</div>
				</div>
				<div class="col-md-7 col-sm-12 col-xs-12">
				<div class="product-deatil">
						<h5 class="name">
							<a href="#">
								${p.name}
							</a>
							<!-- <a href="#">
								<span>Product Category</span>
							</a>    -->                         

						</h5>
						<p class="price-container">
							<span>${p.price} DH</span>
						</p>
						<span class="tag1"></span> 
				</div>
				<div class="description">
					<p>Quantity : ${p.quantity} </p>
				</div>
				<div class="product-info smart-form">
					<div class="row">
						<div class="col-md-12"> 
							<a href="javascript:void(0);" class="btn btn-danger">Like Product</a>
                            <a href="javascript:void(0);" class="btn btn-info">More info</a>
						</div>
						<div class="col-md-12">
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end product -->
	</c:forEach>
</div>


        
</div>
</body>
</html>

