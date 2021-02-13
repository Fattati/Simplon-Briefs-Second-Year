<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
    <title>PHP CRUD</title>
    <!-- Latest compiled and minified Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
</head>
<body>

<!-- container -->
<div class="container">
    <div class="page-header">
        <h4>Create Product</h4>
    </div>
    <div class="row">
        <form class="form-group" id="product-form">
            <div class="col-md-6">
                <div class="form-group">
                    <input type="text" name="name" class="form-control" placeholder="Enter Product Name" id="name">
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <input type="number" name="price" class="form-control" placeholder="Enter Product Price" id="price">
                </div>
            </div>

            <div class="col-md-10">
                <div class="form-group">
                    <textarea rows="1" name="description" class="form-control" placeholder="Enter Product Description"
                              id="description"></textarea>
                </div>
            </div>
            <div class="col-md-2">
                <div class="form-group">
                    <input type="button" name="insert" id="insert" onclick="insertRecord();"
                           class="btn btn-primary btn-sm"
                           value="Insert Product">
                </div>
            </div>
        </form>
    </div>
    <div class="page-header">
        <h4>Product List</h4>
    </div>
    <div class="row">
        <div class="table-responsive">
            <table class="table table-bordered table-striped">
                <thead>
                <tr>
                    <th width="10%">#</th>
                    <th width="15%">Name</th>
                    <th width="10%">Price</th>
                    <th width="50%">Description</th>
                    <th width="15%">Action</th>
                </tr>
                </thead>
                <tbody id="table-data">

                </tbody>
            </table>
        </div>
    </div>
    <!-- Trigger the modal with a button -->
    <button class="btn btn-info btn-lg" data-target="#myModal" data-toggle="modal" id="modalButtonOpen"
            style="visibility:hidden" type="button">
        Open Modal
    </button>
    <!-- Modal (Pop up when detail button clicked) -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="myModal" role="dialog" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button aria-label="Close" class="close" data-dismiss="modal" id="modalButtonClose" type="button">
                        Close
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        Product Editor
                    </h4>
                    <form id="product-update-form">
                        <div class="form-group">
                            <div class="col-sm-12" id="update_field">

                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <input class="btn btn-primary btn-sm" onclick="submitUpdate();" name="submit_update" type="button"
                           value="Save Changes"/>
                </div>
            </div>
        </div>
    </div>
</div> <!-- end .container -->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- Latest compiled and minified Bootstrap JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

 <!--  ALL AJAX SCRIPT WILL COME HERE -->
  
</body>
</html>