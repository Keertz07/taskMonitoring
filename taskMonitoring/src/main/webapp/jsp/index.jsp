<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored = "false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <title>Login </title>
    <style>
    	*{
    margin:0;
    padding:0;
    font-family:sans-serif;
}

.hero{
    height:100%;
    width:100%;
    background-image:linear-gradient(rgba(0,0,0,0.4),rgba(0,0,0,0.4)),url(https://image.cnbcfm.com/api/v1/image/106797687-1605560680606-gettyimages-1229642237-AFP_8VB7RZ.jpeg?v=1608238234);
    background-position: center;
    background-size:cover;
	background-repeat:no-repeat;
    position:absolute;
}
.gender-selection input[type="radio"] {
    display: inline-block;
    width: auto;
    margin-right: 10px; /* Adjust the spacing between radio buttons */
}

.form-box{
    width:380px;
    height: 600px;
    position:relative;
    margin:4% auto;
    padding:5px; 
    border-radius:15px;
    overflow:hidden;
    background:lightcyan;
}
.button-boxes{
    width:220px;
    margin:35px auto;
    position:relative;
    box-shadow: 0 0 20px 9px #ff61241f;
    border-radius:30px;
}
.toggle-btn{
    padding:10px 30px;
    cursor:pointer;
    background:transparent;
    border:0;
    outline:none;
    position:relative;
    color:black;

}

#btns{
    top:0;
    left:0;
    position:absolute;
    width:110px;
    height: 100%;
    background:linear-gradient(to right,grey,grey);
    border-radius:30px;
    transition:.5s;

}
.social-icons{
    margin:30px auto;
    text-align:center;
}
.social-icons img{
    width:30px;
    margin:0 12px;
    box-shadow:0 0 20px 0 #7f7f7f3d;
    cursor:pointer;
    border-radius:50%;
}
.input-group{
    top:180px;
    position:absolute;
    width:280px;
    transition: .5s;
}
.input-field{
    width:100%;
    padding:10px 0;
    margin: 5px 0;
    border-left:0;
    border-top:0;
    border-right:0;
    border-bottom:1px solid black;
    outline:none;
    background: transparent;
    color:black;
}
.submit-btns{
    width:85%;
    padding:10px 30px;
    display:block;
    cursor :pointer;
    margin:auto;
    background:linear-gradient(to right,grey,grey);
    border:0;
    outline:none;
    border-radius:30px;

}
.check-box{
    margin:30px 10px 30px 0;

}

.span{
    color:#777;
    font-size:12px;
    bottom:68px;
    position:absolute;
}
#loginss{
    left:50px;
}
#registerss{
    left:450px;
}
h1 {
text-align: center;
}
    </style>
</head>
<body>
	
    <div class="hero">
    
        <div class="form-box">
        <h1>${message}</h1>
            <div class="button-boxes">
                <div id="btns"></div>
                <button type="button" class="toggle-btn" onclick="loginss()">Log In</button>
                <button type="button" class="toggle-btn" onclick="registerss()">Register</button>
            </div>
            <div class="social-icons">
                <img src="https://clipart-library.com/new_gallery/410617_facebook-icon-transparent-png.jpg">
                <img src="https://news.topusainsights.com/wp-content/uploads/2023/07/twitter-x-logo.jpg">
                <img src="https://www.actiondatatel.com/wp-content/uploads/2022/07/Google-icon.jpg">
            </div>
            <form action="login" modelAttribute="login" method="post" id="loginss" class="input-group">
                <input type="text" class="input-field" name="username" placeholder="User-Id" required>
                <input type="text" class="input-field" name="password"  placeholder="Enter Password" required>
                <br>
                <br>
                <button type="submit" class="submit-btns">Log In</button>
            </form>
			<form action="register" modelAttribute="user" method="post" id="registerss" class="input-group">
			
				<input type="text" class="input-field" name="studentid" placeholder="Student Id" required>
			    <input type="text" class="input-field" name="name" placeholder="Student Name" required>
			    <input type="text" class="input-field" name="username" placeholder="Email Id" required>
			    <input type="text" class="input-field" name="password" placeholder="Enter Password" required>
			    <input type="text" class="input-field" name="dob" placeholder="Date of Birth" required>
			    <input type="text" class="input-field" name="department" placeholder="Department" required>
			     <div class="gender-selection">
			        <input type="radio" id="student" name="usertype" value="Student">
			        <label for="student">Student</label>
			    </div>
			    <br>
			    <br>
			    
			    <button type="submit" class="submit-btns">Register</button>
			</form>
		</div>
        
    </div>
    <script>
        var x = document.getElementById("loginss");
        var y = document.getElementById("registerss");
        var z = document.getElementById("btns");

        function registerss(){
            x.style.left="-400px";
            y.style.left="50px";
            z.style.left="110px";
        }
        function loginss(){
            x.style.left="50px";
            y.style.left="450px";
            z.style.left="0px";
        }

    </script>

</body>
</html>