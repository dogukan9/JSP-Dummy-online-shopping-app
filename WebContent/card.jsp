<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Products</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>My Card</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
			<c:url var="products" value="UserControllerServlet">
						<c:param name="command" value="PRODUCTS" />
			</c:url>
						
				<c:url var="logout" value="UserControllerServlet">
						<c:param name="command" value="LOGOUT" />
				</c:url>
							
							
			
			 		
				<c:url var="buy" value="UserControllerServlet">
						<c:param name="command" value="BUY" />
				</c:url>
						
			<a href="${products}" >Products</a>
			
					<a href="${logout}" >Logout</a>
			<a href="${buy}">Buy</a> 
			
			<table>
			
				
				<c:forEach var="tempProduct" items="${myProducts}">
					
					<!-- set up a link for each student -->
					
					
					
					<tr>
					<td><img src="${tempProduct.image}" width="300" height="200" /></td>
					</tr>										
					<tr>
						<td> ${tempProduct.name} </td>
							<td>Price: ${tempProduct.price} </td>
								<td>Stok: ${tempProduct.stok} </td>
								
					
					
					</tr>
				
				</c:forEach>
					
				
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








