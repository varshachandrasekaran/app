/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = {"/New"})
public class New extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            /* TODO output your page here. You may use following sample code. */
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            int price,total;
            String u=request.getParameter("name");
            String p=request.getParameter("quan");
            int quantity=Integer.parseInt(p);

           Class.forName("org.apache.derby.jdbc.ClientDriver");//Driver Class
           Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/swe","swe","swe");//Database url,username,password
           Statement s=con.createStatement();//Statement
           ResultSet rs=s.executeQuery("select * from product where name='"+u+"'");//Result Set
if(rs.next())
{
price=rs.getInt("price");
total=price*quantity;
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet Serv1</title>");
out.println("");
out.println("</head>");
out.println("<body style='background-color:#f7dad9;'>");
out.println("<center>");
out.println("<h1> <u>COST CALCULATION</u> </h1>");
out.println("<h1>Product:" +u+" </h1>");
out.println("<h1>Quantity:" +quantity+" </h1>");
out.println("<h1>Cost:" +total+" </h1>");
out.println("</center>");
out.println("</body>");
out.println("</html>");
}

else
{
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Servlet Serv1</title>");
out.println("</head>");
out.println("<body>");
out.println("<h1>Invalid User " + u+" </h1>");
out.println("</body>");
out.println("</html>");
}

}
catch(Exception e)
{}
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
