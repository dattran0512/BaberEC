<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://use.fontawesome.com/b32121c496.js"></script>
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


	<!-- Messenger Plugin chat Code -->
    <div id="fb-root"></div>

    <!-- Your Plugin chat code -->
    <div id="fb-customer-chat" class="fb-customerchat">
    </div>

    <script>
      var chatbox = document.getElementById('fb-customer-chat');
      chatbox.setAttribute("page_id", "103711785464781");
      chatbox.setAttribute("attribution", "biz_inbox");
    </script>

    <!-- Your SDK code -->
    <script>
      window.fbAsyncInit = function() {
        FB.init({
          xfbml            : true,
          version          : 'v12.0'
        });
      };

      (function(d, s, id) {
        var js, fjs = d.getElementsByTagName(s)[0];
        if (d.getElementById(id)) return;
        js = d.createElement(s); js.id = id;
        js.src = 'https://connect.facebook.net/vi_VN/sdk/xfbml.customerchat.js';
        fjs.parentNode.insertBefore(js, fjs);
      }(document, 'script', 'facebook-jssdk'));
    </script>

	










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
                            <p>Hello ${accountUser.name}, Welcome to hair salon!</p>
                        </div>
                    </div>
                    <div class="col-7">
                        <div class="top-header-content text-right">
                            <p><i class="fa fa-clock-o" aria-hidden="true"></i> Mon-Sat: 8.00 to 17.00 <span class="mx-2"></span> | <span class="mx-2"></span> <i class="fa fa-phone" aria-hidden="true"></i> Call us: (+12)-345-6789</p>
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
                    <a class="nav-brand" href="index.jsp"><img width="100" src="./img/core-img/logo.png" alt=""></a>
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
                                    <li class="active"><a href="./index.jsp">Home</a></li>
                                    <li><a href="./portfolio.jsp">Portfolio</a></li>
                                    <li><a href="./service.jsp">Services</a></li>
                                    <li><a href="./about.jsp">About Us</a></li>
                                    <li><a href="./blog.jsp">Blog</a></li>
                                    <li><a href="./contact.jsp">Contact</a></li>
                                    <li><a href="./userlogin.jsp">Login</a></li>
                                    <li><a href="./LogoutUser">Logout</a></li>
                                    <li><a href="./userlogin.jsp">Admin</a></li>
                                </ul>

                                <!-- Cart Icon -->
                                <div class="cart-icon ml-5 mt-4 mt-lg-0">
                               	<a href="DisplayUserCart"><i class="icon_cart"></i></a>
                                </div>

                                <!-- Book Icon -->
                                <div class="book-now-btn ml-5 mt-4 mt-lg-0 ml-md-4">
                                    <a href="Booking" class="btn akame-btn">Book Now</a>
                                </div>
                            </div>
                            <!-- Nav End -->
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </header>
    <!-- Header Area End -->


   	<h2> Bookingg </h2>
   	<h4> Chọn cửa hàng </h4>
   		
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

  
  <div class="row">
	<c:forEach items="${listCH}" var="x">
	<div class=" col-sm-3">
	<div class="card"  >
    <img class="rounded"  src="https://cdn.printgo.vn/uploads/media/774255/6_1586684416.jpg" alt="Card image" >
    <div class="card-body">
      <h6 class="card-title">${x.name} <br> ${x.address} </h6>
      <a href="in4CustomerForBooking?Sid=${x.id}"  class="btn btn-primary">Đặt lịch cắt</a>
    </div>
  </div>
  </div>
	</c:forEach>
	</div>
  
  

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

<script type="text/javascript">

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
			window.location.href='SelectTP?idTP='+id;
			}
			
		}
		function selectQH(selectObject){
			var id = selectObject.value;
			if(id!='st2'){
			sessionStorage.setItem("idQH",id);
			window.location.href='SelectQH?idQH='+id;
			}
		}



</script>
</html>