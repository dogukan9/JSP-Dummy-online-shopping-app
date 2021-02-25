package com.web.jdbc;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


@WebServlet("/UserControllerServlet")
public class UserControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDbUtil userDbUtil;
	List<User> users;
	int userId;
	
	@Resource(name="jdbc/web_final_user")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our student db util ... and pass in the conn pool /datasoruce
	  try {
		  userDbUtil=new UserDbUtil(dataSource); 
	  }
	  catch(Exception exc){
		throw new ServletException(exc);
		}
	 
	}


	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		//read the "command" parameter
		 String theCommand=request.getParameter("command");
	
			if(theCommand==null) {
				theCommand="LOGIN";
			}
			
	    // rotue to the appropriate method
			
			switch(theCommand) {
			 case "LOGIN":
				loadLoginPage(request,response);
				break;
				
		     case "login_page":
				loginPage(request,response);
				break;
		
	       	case "register_page":
			 registerPage(request,response);
			    break;
	    	case "LOGOUT":
			logout(request,response);
			break;
			
		    case "PRODUCTS":
			getProducts(request,response);
			break;
			
		   case "ADDTOCARD":
			addToCard(request,response);
			break;
			
		   case "SHOWCARD":
			showCard(request,response);
			break;
			
		   case "BUY":
			buy(request,response);
			break;
			
		   default:
				loadLoginPage(request,response);
			}
			
	
	 }
	  catch(Exception exc){
		throw new ServletException(exc);
		}
		
	}





	private void registerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		String username=request.getParameter("username").trim();
		String password=request.getParameter("password").trim();
		if(!(username.equals("")) || !(password.equals(""))) {
			userDbUtil.addUser(username,password);
			
			 RequestDispatcher dispatcher=request.getRequestDispatcher("/login-users.jsp");
			    dispatcher.forward(request,response);
			
		}
		    
		 
	}




	private void buy(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		List<Product> myProducts=userDbUtil.getShop(userId);
	
		
		for (Product p:myProducts) {
		  
			userDbUtil.updateProduct(p);	
		
		}
		
			userDbUtil.deleteShop(userId);
		 getProducts(request,response);
		
		
		
	}




	private void showCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Product> myProducts=userDbUtil.getShop(userId);
		 
		 request.setAttribute("myProducts", myProducts);

		    RequestDispatcher dispatcher=request.getRequestDispatcher("/card.jsp");
		    dispatcher.forward(request,response);
		
	}




	private void addToCard(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//urunId
		int UrunId=Integer.parseInt(request.getParameter("urunId"));
	
		Product product=userDbUtil.getProduct(UrunId);
		userDbUtil.addCard(product,userId);
		
		   getProducts(request,response);
		
		
	}




	private void getProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Product> products=userDbUtil.getProducts();
		//add students to the request 
		 request.setAttribute("PRODUCTS_LIST",products);
		//send to JSP page (view)
	    RequestDispatcher dispatcher=request.getRequestDispatcher("/products.jsp");
	    dispatcher.forward(request,response);
		
		
	}




	private void loadLoginPage(HttpServletRequest request, HttpServletResponse response) 
	throws Exception{
	
	
	    RequestDispatcher dispatcher=request.getRequestDispatcher("/login-users.jsp");
	    dispatcher.forward(request,response);
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
			
		 HttpSession session = request.getSession(false);
	    
	      session.removeAttribute("username");
			    RequestDispatcher dispatcher=request.getRequestDispatcher("/login-users.jsp");
			    dispatcher.forward(request,response);
			}
	
	
	
	private void loginPage(HttpServletRequest request, HttpServletResponse response) 
			throws Exception{
			
				// get students from db util
				 users=userDbUtil.getUsers();
				int temp=0;
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				String url="/login-users.jsp";
				 for (User u:users) {
					 if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
						 HttpSession session = request.getSession(true);
						 userId=u.getId();
						 session.setAttribute("username",username);
				         temp=temp+1;
						 url="/main_page.jsp";
						 break;
					 }
					 
				 }
				 if(temp==0) {
					 url="/register.jsp";
				 }
				 
			
				//send to JSP page (view)
			    RequestDispatcher dispatcher=request.getRequestDispatcher(url);
			    dispatcher.forward(request,response);
			}

}
