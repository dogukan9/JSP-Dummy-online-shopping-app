<!DOCTYPE html>

  <html>


<body>

<div id="wrapper">
<div id="header">




</div>

<div id="container">
<h3>Register</h3>
<p>You don't have an account please create an account</p>
<form action="UserControllerServlet" method="GET">

<input type="hidden" name="command" value="register_page" />

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
<td><input type="submit" value="Register" class="save"/></td>

</tr>
</tbody>

</table>
 

</form>


</div>








</body>
</html>