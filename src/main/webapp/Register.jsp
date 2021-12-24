<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://use.fontawesome.com/b32121c496.js"></script>
<style>
body{
	background-image :url("https://cdn.wallpapersafari.com/88/95/tCaJ3V.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	font-family: sans-serif;
}
.box-form{
	width: 340px;
	height: 550px;
	margin: 5% auto;
	top:0px;
	padding: 80px 30px;
	background-color: rgb(0,0,0);
	color: #fff;
	
}
h2{
	text-align: center;
	color: #fff;
}
.input-box{
	margin: 10px;
	width: 95%;
	border-bottom: 1px solid #fff;
	padding-top: 1px;
	padding-bottom: 5px;
}
.input-box input{
width:  95%;
border: none;
outline: none;
background: transparent;
color: #fff; 
}
.box-form button {
	color: #fbfcfd;
    padding: 10px 25px;
    background : transparent;
    border: 2px solid #fff;
    border-radius: 20px;
    outline: none;
    cursor: pointer;
    margin:  7px;
}

.btn-ss{
color: #fbfcfd;
    padding: 10px 25px;
    background : transparent;
    border: 2px solid #fff;
    border-radius: 20px;
    outline: none;
    cursor: pointer;
    margin:  7px;
}
.fa{
margin-left: 35px;
}
.btn-box{
margin-bottom: 75px;
}
</style>
<title>Insert title here</title>
</head>

<body>
<section>
<div class="box-form">
 <form action="UserRegister" method="get">
 <span>     ${arlert}    </span>
 <h2> Register  </h2>
 	<table style="with: 100%">
 	<tr>
 	 <td> 
 	  <i class="fa fa-user-o" aria-hidden="true"> </i> </td>
     <td>
   <div class="input-box">  <input type="text" name="username" placeholder="Nhập tài khoản" required > </div>
     </td>  
    </tr>
    <tr>
     <td><i class="fa fa-key" aria-hidden="true"></i></td>
     
     <td>
     <div class="input-box">
     <input type="password"  name="password"  placeholder="Nhập mật khẩu"  required>
     </div>
     </td>
    </tr>
    
       <tr>
     <td><i class="fa fa-key" aria-hidden="true"></i></td>
     
     <td>
     <div class="input-box">
     <input type="password"  name="repassword"  placeholder="Nhập lại mật khẩu" required >
     </div>
     </td>
     
    </tr>
    
      <tr>
     <td><i class="fa fa-user-o" aria-hidden="true"> </i></td>
     
     <td>
     <div class="input-box">
     <input type="text"  name="cName"  placeholder="Nhập tên của bạn" required >
     </div>
     </td>
     
    </tr>
    
    <tr>
     <td><i class="fa fa-phone-square" aria-hidden="true"></i></td>
     
     <td>
     <div class="input-box">
     <input type="text"  name="cPhone"  placeholder="Nhập SDT của bạn" required >
     </div>
     </td>
     
    </tr>
    
   </table>
   	<div class="btn-box">
   	<button type="submit" > Sign Up </button> 
   		&nbsp;
   	<a href="userlogin.jsp" class="btn-ss"> Back</a>
   	</div>
   </form>
   </div>
   </section>
</body>
</html>	