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
  <script src="https://kit.fontawesome.com/79b561acc7.js" crossorigin="anonymous"></script>
    <!-- Stylesheet -->
    <link rel="stylesheet" href="style.css">

<style>
.table{
	width:500px
}
.btn-all{
	display:flex;
}
.payment{
	margin-left: 15px;
}

.table-inline{
  position: relative;
  width: 500px;
  height: 460px;
  margin-left: auto;
  margin-right: auto;
  margin-top:10px;

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
    <c:choose>
    	 <c:when test="${accountUser == null}">
    <div class="table-inline">
    	<form action="AcceptOrder" method="get"> 
    				<div class="nav-text">
				     <h4 style="background-color:rgba(255, 99, 71, 0.5);"> 1.C???a h??ng ???? ch???n</h4>
				     </div>
				     <h5> ${ Order.cuahang.name} </h5>
				    <h5>   ${Order.cuahang.address}        </h5>
				    <div class="nav-text">
					 <h4 style="background-color:rgba(255, 99, 71, 0.5);"> 2. D???ch v??? ???? ch???n </h4>
					 </div>
					 	
				      <table class="table table-hover">
				      <c:set var="total" value="${0}"/> 		
				      <thead>
					      <tr>
					        <th>T??n D???ch V???</th>
					       <th>????n Gi??</th>  
					      </tr>
					   </thead>
					   <tbody>
					   <c:forEach items="${sessionScope.services}" var="x">
					   		<tr>
					   			<td> ${x.value.dichvu.name}  </td>
					   			<td><fmt:setLocale value = "en_US"/>
								  <fmt:formatNumber value = "${x.value.dichvu.price}" type = "currency"/>	    </td>   	
					   		</tr>
					   		 <c:set var="total" value="${total + x.value.dichvu.price}" />			
					   </c:forEach>
					   </tbody>		
					  </table>
					  <div class=""> T???ng h??a ????n:    <fmt:setLocale value = "en_US"/>
													  <fmt:formatNumber value = "${total}" type = "currency"/>	<i class="fab fa-paypal"></i>	  ${Payment}   </div>	
					  <c:set var="totalOrder" value="${total}" scope="session"/>
					  
				<br>
				<div class="nav-text">
				  <h4 style="background-color:rgba(255, 99, 71, 0.5);"> 3. Th???i gian ???? ch???n </h4>	
				  </div>
				    
					 	<h5> Th???i gian: ${Order.orderDate}	</h5>
					 	
						<br>
									
						 </form>	
				<div class="btn-all">	 
	 <a href="#" class="btn btn-secondary" onclick="deleteOrder_js()"> H???y l???ch c???t </a> 
						 
		<div class="payment">		
	<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">

            <!-- Nh???p ?????a ch??? email ng?????i nh???n ti???n (ng?????i b??n) -->
            <input type="hidden" name="business" value="nguoiban@paypal.com">

            <!-- tham s??? cmd c?? gi?? tr??? _xclick ch??? r?? cho paypal bi???t l?? ng?????i d??ng nh???t n??t thanh to??n -->
            <input type="hidden" name="cmd" value="_xclick">

            <!-- Th??ng tin mua h??ng. -->
            <input type="hidden" name="item_name" value="HoaDonMuaHang">
			<!--Tr??? gi?? c???a gi??? h??ng, v?? paypal kh??ng h??? tr??? ti???n vi???t n??n ph???i ?????i ra ti???n $-->
            <input  type="hidden"  min="0" name="amount"  value="${totalOrder}" readonly>
			<!--Lo???i ti???n-->
            <input type="hidden" name="currency_code" value="USD">
			<!--???????ng link m??nh cung c???p cho Paypal bi???t ????? sau khi x??? l?? th??nh c??ng n?? s??? chuy???n v??? theo ???????ng link n??y-->
            <input type="hidden" name="return" value="https://baberweb.herokuapp.com/Payment?idOrder=${idOrder} ">
			<!--???????ng link m??nh cung c???p cho Paypal bi???t ????? n???u  x??? l?? KH??NG th??nh c??ng n?? s??? chuy???n v??? theo ???????ng link n??y-->
            <input type="hidden" name="cancel_return" value="/Booking">
            <!-- N??t b???m. -->
            <input type="submit" name="submit" class="btn btn-success" value="Thanh to??n qua Paypal">
		</form>
		
		</div>				 
					
		</div>		 
			
  </div>	
			</c:when>
			
			<c:when test="${accountUser != null}">
    <div class="table-inline">
    	<form action="AcceptOrder" method="get"> 
    				<div class="nav-text">
				     <h4 style="background-color:rgba(255, 99, 71, 0.5);"> 1.C???a h??ng ???? ch???n</h4>
				     </div>
				     <h5> ${Cuahang.name} </h5>
				    <h5>   ${Cuahang.address}        </h5>
				    <div class="nav-text">
					 <h4 style="background-color:rgba(255, 99, 71, 0.5);"> 2. D???ch v??? ???? ch???n </h4>
					 </div>
					 	
				      <table class="table table-hover">
				      <c:set var="total" value="${0}"/> 		
				      <thead>
					      <tr>
					        <th>T??n D???ch V???</th>
					       <th>????n Gi??</th>  
					      </tr>
					   </thead>
					   <tbody>
					   <c:forEach items="${listDichVu}" var="x">
					   		<tr>
					   			<td> ${x.name}  </td>
					   			<td><fmt:setLocale value = "en_US"/>
								  <fmt:formatNumber value = "${x.price}" type = "currency"/>	    </td>   	
					   		</tr>
					   		 <c:set var="total" value="${total + x.price}" />			
					   </c:forEach>
					   </tbody>		
					  </table>
					  <div class=""> T???ng h??a ????n:    <fmt:setLocale value = "en_US"/>
													  <fmt:formatNumber value = "${total}" type = "currency"/>    <c:if test = "${orderUser.getPayment() == 1}"> <i class="fab fa-paypal"></i> ???? thanh to??n </c:if>  </div>	
					  <c:set var="totalOrder" value="${total}" scope="session"/>
					  
				<br>
				 <div class="nav-text">
				  <h4 style="background-color:rgba(255, 99, 71, 0.5);"> 3. Th???i gian ???? ch???n </h4>	
				  </div>
				    
					 	<h5> Th???i gian: ${orderUser.orderDate}	</h5>
					 	
						<br>
									
						 </form>	
				<div class="btn-all">	 
	 <a href="#" class="btn btn-secondary" onclick="deleteOrder_js()"> H???y l???ch c???t </a> 
						 
		<div class="payment">		
	<form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">

            <!-- Nh???p ?????a ch??? email ng?????i nh???n ti???n (ng?????i b??n) -->
            <input type="hidden" name="business" value="nguoiban@paypal.com">

            <!-- tham s??? cmd c?? gi?? tr??? _xclick ch??? r?? cho paypal bi???t l?? ng?????i d??ng nh???t n??t thanh to??n -->
            <input type="hidden" name="cmd" value="_xclick">

            <!-- Th??ng tin mua h??ng. -->
            <input type="hidden" name="item_name" value="HoaDonMuaHang">
			<!--Tr??? gi?? c???a gi??? h??ng, v?? paypal kh??ng h??? tr??? ti???n vi???t n??n ph???i ?????i ra ti???n $-->
            <input  type="hidden"  min="0" name="amount"  value="${totalOrder}" readonly>
			<!--Lo???i ti???n-->
            <input type="hidden" name="currency_code" value="USD">
			<!--???????ng link m??nh cung c???p cho Paypal bi???t ????? sau khi x??? l?? th??nh c??ng n?? s??? chuy???n v??? theo ???????ng link n??y-->
            <input type="hidden" name="return" value="https://baberweb.herokuapp.com/Payment">
			<!--???????ng link m??nh cung c???p cho Paypal bi???t ????? n???u  x??? l?? KH??NG th??nh c??ng n?? s??? chuy???n v??? theo ???????ng link n??y-->
            <input type="hidden" name="cancel_return" value="/Booking">
            <!-- N??t b???m. -->
            <input type="submit" name="submit" class="btn btn-success" value="Thanh to??n qua Paypal">
		</form>
		
		</div>				 
					
		</div>		 
			
  </div>	
			</c:when>
			
			
			
			
			
	</c:choose>

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

		function deleteOrder_js(){
			if(confirm("B???n ch???c ch???n mu???n h???y ?????t l???ch"))
				window.location.href="DeleteOrder";
			
		}

</script>




</html>