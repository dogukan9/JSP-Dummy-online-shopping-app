package com.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class UserDbUtil {

	
	private DataSource dataSource;
	
	public UserDbUtil(DataSource theDataSource) {
		
		dataSource=theDataSource;
	}
	
	public List<User> getUsers() throws Exception{

		
		
		List<User> users=new ArrayList<>();
		
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
	try {	
		//get a connection
		myConn=dataSource.getConnection();
		
	
		
		//create sql statement
		String sql="select * from user";
		myStmt=myConn.createStatement();
		//execute query
		myRs=myStmt.executeQuery(sql);
		
		//process result set
		while(myRs.next()) {
			
			//retrieve data drom result set row
			int id=myRs.getInt("id");;
			String username=myRs.getString("username");
			String password=myRs.getString("password");
			

			//create new student object
		User tempUser=new User(id, username, password);
		
           //add it to the list of students
			
		
			
			users.add(tempUser);
		}
		
		
		
		
		return users;
	}
	finally {
		//close JDBC objects
		close(myConn,myStmt,myRs);
		
	}
	
		
		
	}
	
	
	
	
	public List<Product> getShop(int userId) throws Exception{
	List<Product> products=new ArrayList<>();
		
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
	try {	
		//get a connection
		myConn=dataSource.getConnection();
		
	
		
		//create sql statement
		String sql="select * from cards where userId="+userId;
		
		
		myStmt=myConn.createStatement();
		//execute query
		myRs=myStmt.executeQuery(sql);
		
		//process result set
		while(myRs.next()) {
			
			//retrieve data drom result set row
			int id=myRs.getInt("id");;
			String name=myRs.getString("name");
			int stok=myRs.getInt("stok");
			String image=myRs.getString("image");
			int price=myRs.getInt("price");
			

			//create new student object
		Product tempProduct=new Product(id,name,stok,image,price);
		
           //add it to the list of students
			
		
			
			products.add(tempProduct);
		}
		
		
		
		
		return products;

	 
			
		
		
		
	}
	finally {
		//close JDBC objects
		close(myConn,myStmt,myRs);
		
	}
	
		
		
	}
	
	public List<Product> getProducts() throws Exception{
		
		
		List<Product> products=new ArrayList<>();
		
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
	try {	
		//get a connection
		myConn=dataSource.getConnection();
		
	
		
		//create sql statement
		String sql="select * from products";
		
		
		myStmt=myConn.createStatement();
		//execute query
		myRs=myStmt.executeQuery(sql);
		
		//process result set
		while(myRs.next()) {
			
			//retrieve data drom result set row
			int id=myRs.getInt("id");;
			String name=myRs.getString("name");
			int stok=myRs.getInt("stok");
			String image=myRs.getString("image");
			int price=myRs.getInt("price");
			

			//create new student object
		Product tempProduct=new Product(id,name,stok,image,price);
		
           //add it to the list of students
			
		
			
			products.add(tempProduct);
		}
		
		
		
		
		return products;
	}
	finally {
		//close JDBC objects
		close(myConn,myStmt,myRs);
		
	}
	
		
		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			
			if(myRs!=null) {
				myRs.close();
			}
			if(myStmt !=null) {
				myStmt.close();
			}
			if(myConn !=null) {
				myConn.close();  //doesn't really close it ... just puts back in connection pool 
			}
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
	}


		 
		
		
		
	
	public void addCard(Product theProduct,int userId) throws SQLException {
		
		 Connection myConn=null;
		 PreparedStatement myStmt=null;
		 try {
			 //get db connection
			 myConn=dataSource.getConnection();
			 
			// create sql for insert
		
			 String sql="insert into cards "
					 +"(name, stok, price,image,userId)"+
					 " values (?, ?,?,?,?)";
			 
			 myStmt=myConn.prepareStatement(sql);
			 //set the param values for the student
			  
			 myStmt.setString(1,theProduct.getName());
			 myStmt.setInt(2,theProduct.getStok()); 
			 myStmt.setInt(3,theProduct.getPrice());
			 myStmt.setString(4,theProduct.getImage());
			 myStmt.setInt(5,userId);
			 
			 
				//execute sql insert
				myStmt.execute();
		 }
		 
		 finally {
			 //clean up JDBC objects
			 close(myConn,myStmt,null);
		 }
		 
		
		
		
	
	
		
	}
		

	public Product getProduct(int theId) throws Exception {
		
		Connection myConn=null;
		PreparedStatement ps=null;
				ResultSet rs=null;
			Product theProduct;
try {
	
	myConn=dataSource.getConnection();
	

	
	String sql="select * from products where id=?";
	//create prepared statement
	
	ps=myConn.prepareStatement(sql);
	
	//set params
	ps.setInt(1,theId);
	
	//execute statement
	
	rs=ps.executeQuery();
	
	//retrieve data from result set row
	if(rs.next()) {
		
		int id=rs.getInt("id");;
		String name=rs.getString("name");
		int stok=rs.getInt("stok");
		String image=rs.getString("image");
		int price=rs.getInt("price");
		//use the studentId during construction
		
		theProduct=new Product(id,name,stok,image,price);
	}
	else {
		
		throw new Exception("Could not find product id: "+theId);
	}
	
	
	return theProduct;
	
}

finally {
	
	//clean up JDBC objects
	close(myConn,ps,rs);
}
				
		
	}

	public void updateProduct(Product theProducts) throws Exception {
		Connection myConn=null;
		PreparedStatement ps=null;
		System.out.println(theProducts.getId());
		
		try {
		//get connection to database
		myConn=dataSource.getConnection();
		
		
		
		String sql="update products "+
		"set stok=?"
				+" where name=?";
		//create prepared statement
		
		ps=myConn.prepareStatement(sql);
		
		//set params
		
		ps.setInt(1,theProducts.getStok()-1);
		ps.setString(2,theProducts.getName());
	      
		 ps.execute();
		}
		finally {
			
			close(myConn,ps,null);
		}
	
	}

	public void deleteShop(int userId) throws SQLException {
	 
	
		Connection myConn=null;
		PreparedStatement ps=null;
		
		try {
		//get connection to database
		myConn=dataSource.getConnection();
		
		//create sql to delete student
		
		String sql="delete from cards where userId=?";
		//create prepared statement
		
		ps=myConn.prepareStatement(sql);
		
		//set params
		
		ps.setInt(1,userId);
	      
		 ps.execute();
	
	//retrieve data from result set row
	
	
	

	
}

finally {
	
	//clean up JDBC objects
	close(myConn,ps,null);
}

		
	}

	public void addUser(String username, String password) throws SQLException {
		Connection myConn=null;
        PreparedStatement myStmt=null;
        try {
            //get db connection
            myConn=dataSource.getConnection();

           // create sql for insert

            String sql="insert into user "
                    +"(username,password)"+
                    " values (?, ?)";

            myStmt=myConn.prepareStatement(sql);
            //set the param values for the student

            myStmt.setString(1,username);
            myStmt.setString(2,password); 


               //execute sql insert
               myStmt.execute();
        }

        finally {
            //clean up JDBC objects
            close(myConn,myStmt,null);
        }
	}

	
}

