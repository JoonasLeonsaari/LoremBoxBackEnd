/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Files;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 *
 * @author joonasrl
 */
@WebServlet(name = "FileUpload", urlPatterns = {"/do"})
@MultipartConfig(location = "/var/www/html/uploads")
public class Upload extends HttpServlet {
    
    @EJB
    private DBControl dbc;

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
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            request.getPart("fileup").write(request.getPart("fileup").getSubmittedFileName());
            out.print("{\"src\" : \"10.114.34.143/uploads/" + request.getPart("fileup").getSubmittedFileName() +"\"}");
            String fileName = "10.114.34.143/uploads/" + request.getPart("fileup").getSubmittedFileName();
            
            Files f = new Files();
            
            f.setFileName(fileName);
            dbc.insertFiles(f);
            
        }
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
