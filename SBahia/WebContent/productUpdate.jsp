<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>

        <section>
<div class="container">
            <div class="form-group">
                <form action="update.do" method="post" enctype="multipart/form-data">
                <div class="page-header">
                    <h3>Update Product</h3>
                    </div>
                    <div class="form-group">
                    <div ><input class="form-control" type="text" value="${product.name}"  name="name" placeholder="name" required /></div>
                   </div>
                   <div class="form-group">
                    <div><input class="form-control" type="number" value="${product.quantity}" name="quantity" placeholder="quantity" required /></div>  
                   </div>
                   <div class="form-group">
                    <div><input class="form-control" type="number" value="${product.price}" name="price" placeholder="price" required /></div>   
                   </div>
                    <div class="form-group">
                        <input type="file" class="form-control-file" id="exampleFormControlFile1" name="img" name="file" required  />
                    </div>
                    <div class="form-group"><input type="submit" value="Update" role="button" class="btn btn-primary btn-sm" /></div>
                </form>
                <div class="img-upload"></div>

            </div>
            </div>

        </section>

        <footer class="footer-page-admin">
            <p></p>
        </footer>
</body>
</html>