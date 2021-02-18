
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
   <head>
      <title>Admin Panel</title>
      <!-- Latest compiled and minified Bootstrap CSS -->
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
   </head>
   <body>
  <div class="navbar navbar-default" >
<ul class="nav navbar-nav">
<li><a  class="float-right" href="logout">Logout</a></li>
</ul>

</div>
      <!-- container -->
      
      <div class="container">
         <div class="page-header">
            <h4>Create Product</h4>
         </div>
         <div class="row">
            <form action="addProduct.do" method="post" enctype="multipart/form-data" class="form-group" id="product-form">
               <div class="col-md-6">
                  <div class="form-group">
                     <input type="text" name="name" class="form-control" placeholder="Enter Product Name" id="name">
                     </div>
                     <div class="form-group">
                     <input type="file" class="file" name="img" accept="image/*" required  />
                  </div>
               </div>
               <div class="col-md-6">
                  <div class="form-group">
                     <input type="number" name="price" class="form-control" placeholder="Enter Product Price" id="price">
                  </div>
               </div>
               <div class="col-md-6">
                  <div class="form-group">
                     <input type="number" name="quantity" class="form-control" placeholder="Enter Product Quantity" id="quantity">
                  </div>
               </div>   
               <!--             <div class="col-md-10"> -->
               <!--                 <div class="form-group"> -->
               <!--                     <textarea rows="1" name="description" class="form-control" placeholder="Enter Product Description" -->
               <!--                               id="description"></textarea> -->
               <!--                 </div> -->
               <!--             </div> -->
               <div class="col-md-2">
                  <div class="form-group">
                     <input type="submit" name="insert" id="insert" onclick="insertRecord();"
                        class="btn btn-primary"
                        value="Insert Product">
                  </div>
               </div>
            </form>
         </div>

         <div class="page-header">
            <h4>Product List</h4>
                     <form class="form-group" action="search.do" method="Get">
            <input type="text" name="n" class="search-txt"/>
            <input type="submit" id="search" onclick="insertRecord();"
               class="btn btn-primary btn-sm"
               value="Search">
         </form>
         </div>
         
         <div class="row">
            <div class="table-responsive">
               <table class="table table-bordered table-striped">
                  <thead>
                     <tr>
                        <th width="10%">Product Image</th>
                        <th width="15%">Name</th>
                        <th width="10%">Price</th>
                        <th width="10%">Quantity</th>
                        <th width="10%">Action</th>
                     </tr>
                  </thead>
                  <tbody id="table-data">
                     <c:forEach items="${product}" var="p" varStatus="status">
                        <tr>
                           <td>  <img src="data:img/*;base64,${img[status.index]}" class="img-thumbnail">  </td>
                           <td class="column-name">${p.name}  </td>
                           <td>${p.price} DH </td>
                           <td>${p.quantity} </td>
                           <td>
                              <a class="btn btn-primary" role="button" href="edit.do?productId=${p.productId}" > Update </a>
                              <a class="btn btn-primary" role="button" onclick="return confirm('Are you sure?')" href="delete.do?productId=${p.productId}"> Delete</a>
                           </td>
                        </tr>
                     </c:forEach>
                  </tbody>
               </table>
            </div>
         </div>
      </div>
      <!-- Trigger the modal with a button -->
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
      <!-- Latest compiled and minified Bootstrap JavaScript -->
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
      <!--  ALL AJAX SCRIPT WILL COME HERE -->
   </body>
</html>

