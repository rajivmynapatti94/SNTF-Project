package com.sntf.steps;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class DatabaseTesting {
	private static Statement stm;
	private static Connection con;
	public static PreparedStatement preparedStmt;
	
	public static String fname = "Rajiv";
	public static String lname = "kumar";
	public static String email = "rajiv.mynapatti+116@indianic.com";
	public static String usertype ="Normal";
	public static String Created_date;
	public static int Isverified = 1;
	
	String Select_Query = "Select * from users WHERE email = '"+email+"'";
	String Insert_Query = "INSERT INTO users (user_type, first_name, last_name, email, password, created_at, updated_at) values(?,?,?,?,?,?,?)";
	String Update_Query = " UPDATE users SET first_name = 'Manoj', last_name ='"+lname+"', verified ="+Isverified+" WHERE email = '"+email+"';";
	String Delete_Query = "DELETE FROM users WHERE email = '"+email+"';";
	
	@BeforeTest
	     public static void Connect_Database() throws SQLException, ClassNotFoundException {	
			String dbURL = "jdbc:mysql://10.2.1.64:3306/alpha_sntf";
			String username = "alpha_sntf";
	        String password = "alpha_sntf";
	        try{
	       
	        	//Load MySQL JDBC Driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        
	        //Creating connection to the database
	        con = DriverManager.getConnection(dbURL,username,password);
	      //  System.out.println("I m connected to database");
	        
	        stm = con.createStatement();
	        }
            catch (Exception e)
            {
                  e.printStackTrace();
            }
	    }
		
		@Test (priority =1)
	     public void Insert_Query() throws SQLException, UnsupportedEncodingException {
			
			ResultSet rs=  stm.executeQuery(Select_Query);
			//System.out.println(rs.first());
			
			if(rs.first()==false) {
			
				String password = BCrypt.hashpw("Indianic@1", BCrypt.gensalt());
				
				//System.out.println("Hash password is "+password);

				//The below code will get the UTC current time in the below format to add data in Created_At and Updated_at column in USERS Table
				SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				f.setTimeZone(TimeZone.getTimeZone("UTC"));		
				Created_date = f.format(new Date()); //System.out.println(current_date);
				
				
				// create the mysql insert preparedstatement
				
				PreparedStatement preparedStmt = con.prepareStatement(Insert_Query);
				
				preparedStmt.setString(1, usertype); //setString means it will add the usertype in the user_type column 
				
				preparedStmt.setString(2, fname); //setString means it will add the firstname in the first_name column

				preparedStmt.setString(3, lname); //setString means it will add the lastname in the last_name column
				
				preparedStmt.setString(4, email); //setString means it will add the email in the email column
				
				preparedStmt.setString(5, password); //setString means it will add the password in the password column
				
				preparedStmt.setString(6, Created_date); //setString means it will add the created date in the created_at column
				
				preparedStmt.setString(7, Created_date); //setString means it will add the Updated date in the Updated_at column
				
				// execute the preparedstatement
				 preparedStmt.execute();
			}
				else {
					System.out.println("Email id is already exits within the system");
				}
			}
		
		@Test (priority =2)
		 public void Select_query() throws SQLException {
			try {
				
			// Now execute the query

					ResultSet rs=  stm.executeQuery(Select_Query);
						
						// Iterate the resultset now

						while(rs.next()){

						fname =rs.getString("first_name");
						email = rs.getString("email");
							lname=rs.getString("last_name");
							 String password = rs.getString("password");
							
							System.out.println("Uname is "+fname+" LastName is "+lname+" email id is "+email+" Password is "+password);
							
						}
					}
					catch (Exception e) {
						System.out.println("No Data found");
						System.out.println(e.getMessage());
					}
		}
		
		@Test(priority = 3)
		 public void Update_query () throws SQLException {
			
			PreparedStatement preparedStmt = con.prepareStatement(Update_Query);
			
			preparedStmt.execute();
			
			System.out.println("Update Query has been executed successfully");
			
			Select_query();
			

		}
		
		//@Test (enabled = false) 
		@Test (priority = 4)
		 public void Delete_query() throws SQLException {
			
			PreparedStatement preparedStmt = con.prepareStatement(Delete_Query);
			
			preparedStmt.execute();
			
			System.out.println("Delete Query has been executed successfully");
		}
		
	   @AfterTest
		 public void Disconnect_Database() throws Exception {
	              // Close DB connection
	              if (con != null) {
	              con.close();
	              }
	              
	       }
	}


