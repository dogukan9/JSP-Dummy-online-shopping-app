<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Products</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
	 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>PRODUCTS</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
				
				<c:url var="logout" value="UserControllerServlet">
						<c:param name="command" value="LOGOUT" />
							</c:url>
						
		
			
					<a href="${logout}" >Logout</a>
		<c:url var="show" value="UserControllerServlet">
						<c:param name="command" value="SHOWCARD" />
						</c:url>
						
		  <a href="${show}"><i style="position: absolute;top:20px; right:20px;"class="fas fa-shopping-cart"></i></a>
		
			
			
			
			<table>
			
				
				<c:forEach var="tempProduct" items="${PRODUCTS_LIST}">
					
					<!-- set up a link for each student -->
					<c:url var="add" value="UserControllerServlet">
						<c:param name="command" value="ADDTOCARD" />
						<c:param name="urunId" value="${tempProduct.id}" />
					</c:url>
					
					
					<tr>
					<td><img src="${tempProduct.image}" width="300" height="200" /></td>
					</tr>										
					<tr>
						<td> ${tempProduct.name} </td>
							<td>Price: ${tempProduct.price} </td>
								<td>Stok: ${tempProduct.stok} </td>
								
					
						<td> 
							<a href="${add}">Add To Card</a> 
						
							
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>








