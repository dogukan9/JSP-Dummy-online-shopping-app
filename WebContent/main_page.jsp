<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>WELCOME PAGE</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<p>WELCOME ${param.username}</p>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
		
			
			<c:url var="products" value="UserControllerServlet">
						<c:param name="command" value="PRODUCTS" />
						</c:url>
						
						<c:url var="show" value="UserControllerServlet">
						<c:param name="command" value="SHOWCARD" />
						</c:url>
						
						
				
						
		  <a href="${show}"><i style="position: absolute;top:20px; right:20px;"class="fas fa-shopping-cart"></i></a>
			
			
		<c:url var="logout" value="UserControllerServlet">
						<c:param name="command" value="LOGOUT" />
						
					</c:url>
			<a href="${products}" >Products</a>
				<a href="${show}" >Card</a>
					<a href="${logout}" >Logout</a>
		    
		</div>
	
	</div>
</body>


</html>








