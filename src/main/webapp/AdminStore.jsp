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
.card{
 	width: 100%;
    height: 375px;
    object-fit: cover;  
}
.row img {
    width: 100%;
    height: 250px;
    object-fit: cover;
}
.row{
	margin-left:90px;
	margin-right:90px;
	margin-top: 35px;
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
			
	<select id="selectThanhPho" name="type" onchange="selectTP(this)">
	  <option value="st1" >Chọn Thành Phố</option>
	  <c:forEach items="${listThanhPho}" var="x">
	  		<option value="${x.id}">${x.name}</option>
	  </c:forEach>
  </select>

 <select id="selectQuanHuyen" name="type" onchange="selectQH(this)">
	 <option value="st2">Chọn Quận/Huyện</option>
	  <c:forEach items="${listQH}" var="x">
	  		<option value="${x.id}">${x.name}</option>
	  </c:forEach>
  </select>
  <br>
  	 <a type="button" href="AdminAddStore_GetAllCity" class="btn btn-primary">Thêm cửa hàng</a>	
	  <div class="row">
		<c:forEach items="${listCH}" var="x">
		<div class=" col-sm-3">
		<div class="card"  >
	    <img class="rounded"  src="https://cdn.printgo.vn/uploads/media/774255/6_1586684416.jpg" alt="Card image" >
	    <div class="card-body">
	      <h6 class="card-title">${x.name} <br> ${x.address} </h6>
	      <a href="AdminUpdateStore_GetInfor?Sid=${x.id}"  class="btn btn-primary">Sửa</a>    &nbsp;    <a href="AdminDeleteStore?Sid=${x.id}"  class="btn btn-danger" >Xóa</a>
	    </div>
	  </div>
	  </div>
		</c:forEach>
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
	if(sessionStorage.getItem("idTP")==null){
		document.getElementById('selectThanhPho').value=st1;
	}
	
	if(sessionStorage.getItem("idQH")==null ){
		document.getElementById('selectQuanHuyen').value=st2;
	}
	
	document.getElementById('selectThanhPho').value=sessionStorage.getItem("idTP");
	document.getElementById('selectQuanHuyen').value=sessionStorage.getItem("idQH");
	
	
		function selectTP(selectObject){
			var id = selectObject.value;
			document.getElementById('selectQuanHuyen').value='st2';
			sessionStorage.setItem("idQH","st2");
			if(id!='st1'){
			sessionStorage.setItem("idTP",id);
			window.location.href='AdminStoreSelectTP?idTP='+id;
			}
			
		}
		function selectQH(selectObject){
			var id = selectObject.value;
			if(id!='st2'){
			sessionStorage.setItem("idQH",id);
			window.location.href='AdminStoreSelectQH?idQH='+id;
			}
		}


</script>

</html>