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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://use.fontawesome.com/b32121c496.js"></script>
    <!-- Stylesheet -->
    <link rel="stylesheet" href="style.css">

<style>
.table{
	width:500px
}

.table-inline{
  position: relative;
  width: 500px;
  height: 600px;
  margin-left: auto;
  margin-right: auto;
}

.nav-text{
	margin-top: 20px;
	 text-align: center;
	 
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
                               	<a href="Cart.jsp"><i class="icon_cart"></i></a>
                                </div>

                                <!-- Book Icon -->
                                <div class="book-now-btn ml-5 mt-4 mt-lg-0 ml-md-4">
                                    <a href="DisplayUserCart" class="btn akame-btn">Book Now</a>
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
    
    	<form action="AcceptOrder" method="get" class="was-validated"> 
				<div class="table-inline">
					<div class="nav-text">
				     <h4 style="background-color:rgba(255, 99, 71, 0.5);"> 1.Cửa hàng đã chọn</h4>
				     </div>
				     <h5> ${Sname } </h5>
				    <h5>   ${Saddress}        </h5>
					 <div class="nav-text">
					 <h4 style="background-color:rgba(255, 99, 71, 0.5);"> 2.Chọn dịch vụ </h4>
					 </div>
					 <select id="selectDichVu" name="type" >
  						<c:forEach items="${listDichVu}" var="x">
  						<option value="${x.id}">${x.name}</option>
 						</c:forEach>
 					 </select>
			
					 <a type="button" class="btn btn-secondary" onclick="selectServices()">Thêm</a>
					  <div class="alert alert-warning">
  					  <span> ${Alert} </span>
 					 </div>
				      <table class="table table-hover">
				      <c:set var="total" value="${0}"/> 		
				      <thead>
					      <tr>
					        <th>Tên Dịch Vụ</th>
					        <th>Đơn Giá</th>
					        <th> Xóa </th>
					      </tr>
					   </thead>
					   <tbody>
					   <c:forEach items="${sessionScope.services}" var="x">
					   		<tr>
					   			<td> ${x.value.dichvu.name}  </td>
					   			<td><fmt:setLocale value = "en_US"/>
								  <fmt:formatNumber value = "${x.value.dichvu.price}" type = "currency"/>	    </td> 
					   			<td>  <a href="DeleteServices?idServices=${x.key}" id="DeleteSevices_js"  > X </a>   </td>
					   		</tr>
					   		 <c:set var="total" value="${total + x.value.dichvu.price}" />			
					   </c:forEach>
					   </tbody>		
					  </table>
					  <div class=""> Tổng hóa đơn:<fmt:setLocale value = "en_US"/>
								  				<fmt:formatNumber value = "${total}" type = "currency"/>	          </div>	
					  <c:set var="totalOrder" value="${total}" scope="session"/>
					  
			<div class="nav-text">
				<h4 style="background-color:rgba(255, 99, 71, 0.5);"> 3. Nhập thông tin của bạn</h4> 
				</div>
					 <input type="text" name="Cname" value="${accountUser.name }" placeholder="Nhập tên của bạn" required>
					 <input type="text" name="Cphone" value="${accountUser.phone }" placeholder="Nhập SDT của bạn" required>		 
				<br>
				
				<div class="nav-text">
				  <h4 style="background-color:rgba(255, 99, 71, 0.5);"> 4. Chọn thời gian </h4>	
				  </div>
				    	<div class="alert alert-warning">
  						  <span> Vui lòng nhập thứ tự ngày và giờ theo đúng yêu cầu </span>
 						</div>
					 	<input type="text" name="Cdate" placeholder="Nhập ngày. yyyy-mm-dd  " required>
					 	<input type="text" name="Ctime" placeholder="Nhập giờ. hh:mm:ss  " required>	
						
						<br>
						 <input type="submit"   class="btn btn-secondary" onclick="acceptServices_js()" value ="Đặt lịch cắt"/>
						 
				</div>
				
				
			</form>	
				

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

		function selectServices(){
			var idServices= document.getElementById('selectDichVu').value
			window.location.href='AddServices?idDV='+idServices;
		}
		
		function acceptServices_js(){
			alert("Đặt lịch cắt thành công. Cảm ơn bạn đã chọn dịch vụ của chúng tôi");
		}
		
		
		
		


</script>




</html>