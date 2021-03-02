<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/datepicker.css">
    <link rel="stylesheet" href="css/style2.css">
  </head>

    <body>
      <div class="inner-layer">
          <div class="container">
            <div class="row no-margin">
                <div class="col-sm-7">
                    <div class="content">
                        <h1>Book Your Rendezvous Now and Save your time</h1>
                        
                    </div>
                </div>
                <div class="col-sm-5">
                    <div class="form-data">
                        <div class="form-head">
                            <h2>Book Rendezvous</h2>
                        </div>
                        
                        <div class="form-body">
                        <form action="Rendezvous" method="post">
                            <div class="row form-row">
                              <input type="text" name="title" placeholder="Enter Title" class="form-control">
                            </div>
                            <div class="row form-row">
                              <input type="text" name="animalType" placeholder="Enter Animal" class="form-control">
                            </div>
<!--                              <div class="row form-row"> -->
<!--                               <input type="text" placeholder="Enter Email Adreess" class="form-control"> -->
<!--                             </div> -->
                           <div class="row form-row">
                              <input id="dat" type="text" name="rendezvousDate" placeholder="Rendezvous Date" class="form-control">
                            </div>
                            
<!--                             <h6>Address Details</h6> -->

<!--                              <div class="row form-row"> -->
<!--                                 <div class="col-sm-6"> -->
<!--                                    <input type="text" placeholder="Enter Area" class="form-control"> -->
<!--                                 </div> -->
<!--                                 <div class="col-sm-6"> -->
<!--                                    <input type="text" placeholder="Enter City" class="form-control"> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                              <div class="row form-row"> -->
<!--                                 <div class="col-sm-6"> -->
<!--                                    <input type="text" placeholder="Enter State" class="form-control"> -->
<!--                                 </div> -->
<!--                                 <div class="col-sm-6"> -->
<!--                                    <input type="text" placeholder="Postal Code" class="form-control"> -->
<!--                                 </div> -->
<!--                             </div> -->

                             <div class="row form-row">
                               <button  type="submit"  class="btn btn-success btn-appointment">
                                 Book Rendezvous
                               </button>
                               
                            </div>
                            </form>
                            

                        </div>
                    </div>
                </div>
            </div>
          </div>
      </div>
      
    </body>
  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-datepicker.js"></script>

    <script>
      $(document).ready(function(){
          $("#dat").datepicker();
      })
    </script>
    
  </body>
</html>