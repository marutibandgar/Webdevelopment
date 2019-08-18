/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Suraj
 */
public class DataInsert extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PreparedStatement pst,pst1;
        ResultSet rs;
        PrintWriter pw = response.getWriter();
        
        try{
                   
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/Medical", "root", "root@123");
      
                   

            String TOD = request.getParameter("td");
            String First_name = request.getParameter("fn");
            String Last_name = request.getParameter("ln");           
            String Gender= request.getParameter("gender");
            String Phone_no=request.getParameter("phno");
            String DOB = request.getParameter("dob");
            String marital= request.getParameter("Mstatus");
            String Address= request.getParameter("address");
            String City= request.getParameter("city");
            String State= request.getParameter("state");
            String Zipcode= request.getParameter("zip");
            String Country= request.getParameter("country");
            String insurance= request.getParameter("insurance");         
            String RFirst_name = request.getParameter("rfn");
            String RLast_name = request.getParameter("rln");
            String RPhone_no=request.getParameter("rphno");
            String RAddress= request.getParameter("raddress");
            
           
           
          
            
            
        
          
            

            
            
            pst = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1,TOD);
            pst.setString(2 ,First_name);
            pst.setString(3,Last_name);
            pst.setString(4,Gender);
            pst.setString(5,Phone_no);
            pst.setString(6,DOB);
            pst.setString(7,marital);
            pst.setString(8,Address);
            pst.setString(9,City);
            pst.setString(10,State);
            pst.setString(11,Zipcode);
            pst.setString(12,Country);
            pst.setString(13,insurance);
            pst.executeUpdate();
             pst1= con.prepareStatement("insert into rpatients values(?,?,?,?)");
            pst1.setString(1 ,RFirst_name);
            pst1.setString(2,RLast_name);
            pst1.setString(3,RPhone_no);
            pst1.setString(4,RAddress);
            pst1.executeUpdate();
            
            
            
            
            
            
            

              //  pw.print("<h2>Data Insertion Successfully<h2>");
            response.sendRedirect("inserted.html");
  
                    
            
            
           

            
        }
        catch(Exception e)
        {
            pw.print("<h2>Error<h2>"+e);
        }
        
        
        
        
        
        
    }

}
