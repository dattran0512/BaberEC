<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
 <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Title -->
    <title>Epil & Beauty</title>

    <!-- Favicon -->
    <link rel="icon" href="./img/core-img/favicon.ico">

    <!-- Stylesheet -->
    <link rel="stylesheet" href="style.css">

<style>
.container{
		margin-top: 50px;
	  margin-left: auto;
 	  margin-right: auto;
	 width: 550px;
}


</style>






</head>


<body>
    <!-- Preloader -->
    <div id="preloader">
        <div class="loader"></div>
    </div>
    <!-- /Preloader -->

    <!-- Header Area Start -->
    <header class="header-area">
        <!-- Top Header Area Start -->
        <div class="top-header-area">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-5">
                        <div class="top-header-content">
                            <p>Nice to see you again, my lord!</p>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
        <!-- Top Header Area End -->

        <!-- Main Header Start -->
        <div class="main-header-area">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Classy Menu -->
                    <nav class="classy-navbar justify-content-between" id="akameNav">

                        <!-- Logo -->
                        <a class="nav-brand" href="#"><img width="100" src="./img/core-img/logo.png" alt=""></a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">
                            <!-- Menu Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>
                            <!-- Nav Start -->
                           <div class="classynav">
                                <ul id="nav">
                                     <li class="active"><a href="./fManagement.jsp">Home</a></li>
                                    <li><a href="#">Manage</a>
                                        <ul class="dropdown">
                                            <li><a href="./AdminGetAllServices">Services</a></li>
                                            <li><a href="./AdminGetAllCitys">City</a></li>
                                            <li><a href="./AdminGetAllDistrict">Dictrict</a></li>
                                            <li><a href="./AdminStore"> Baber Store</a></li>
                                            <li><a href="./AdminOrder"> Order </a></li>
                                        </ul>
                                    </li>
                                  
                                  <li><a href="index.jsp">Back to Baber Shop</a>
                                </ul>

                              
                            </div>
                            <!-- Nav End -->
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- Header Area End -->
			
	<div class="container">
  	<h2>Sửa dịch vụ</h2>
    <form action="AdminUpdateServices2">
    <div class="form-group">
      <label for="text">ID</label>
      <input type="text" class="form-control" id="service" value="${id}" name="id" readonly required>
    </div>
    <div class="form-group">
      <label for="text">Tên dịch vụ</label>
      <input type="text" class="form-control" id="service" value="${name}" name="name" required>
    </div>
    <div class="form-group">
      <label for="text">Giá</label>
      <input type="text" class="form-control" id="price" value="${price}"  name="price" required>
    </div>
    <button type="submit" class="btn btn-primary">Sửa dịch vụ</button>
   </form>
	</div>
			
			
			
			
			
			
			
			
			
			

    <!-- Footer Area End -->

    <!-- All JS Files -->
    <!-- jQuery -->
    <script src="js/jquery.min.js"></script>
    <!-- Popper -->
    <script src="js/popper.min.js"></script>
    <!-- Bootstrap -->
    <script src="js/bootstrap.min.js"></script>
    <!-- All Plugins -->
    <script src="js/akame.bundle.js"></script>
    <!-- Active -->
    <script src="js/default-assets/active.js"></script>

</body>
<script>

</script>

</html>