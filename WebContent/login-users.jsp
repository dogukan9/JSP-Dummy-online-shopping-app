<!DOCTYPE html>

  <html>


<body>

<div id="wrapper">
<div id="header">




</div>

<div id="container">
<h3>Login</h3>

<form action="UserControllerServlet" method="GET">

<input type="hidden" name="command" value="login_page" />

<table>
<tbody>

<tr>
<td><label>Username:</label></td>
<td><input type="text" name="username" /></td>

</tr>

<tr>
<td><label>Password:</label></td>
<td><input type="text" name="password" /></td>

</tr>



<tr>
<td><label></label></td>
<td><input type="submit" value="Login" class="save"/></td>

</tr>
</tbody>

</table>
 

</form>


</div>








</body>
</html>