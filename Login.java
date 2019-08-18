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
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        
           try {
              
            
            String user = request.getParameter("Username");
            String pass = request.getParameter("Password");
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/Medical", "root", "root@123");
      
         
            PreparedStatement pst = con.prepareStatement("select * from Users where username=? and Password=?");
            pst.setString(1, user);
            pst.setString(2, pass);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                response.sendRedirect("Sample.html");
            } 
            else {
                
                 pw.print("Sorry user not valid");
        
            }

        } catch (Exception ex) {
           pw.print("ERRor" + ex);
        }
        
        
        
        
    }

}
