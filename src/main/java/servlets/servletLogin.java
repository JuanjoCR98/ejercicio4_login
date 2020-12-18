/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juanjo Cortés
 */
public class servletLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            String user = request.getParameter("usuario");
            String password = request.getParameter("password");
            Cookie cookies[] = request.getCookies();
            Cookie c;
            Cookie cookie;
                    
            if (user.equals("admin") && password.equals("1234")) {
                if (cookies != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        if (!cookies[i].getName().equals("usuario_logueado")) {
                            c= new Cookie("usuario_logueado", "admin");
                            //La cookie se almacenará en el cliente por 1 minuto (60 seg)
                            c.setMaxAge(60);
                            response.addCookie(c);
                            //Mandamos el mensaje al navegador        
                            response.setContentType("text/html");
                        }else{
                            cookie = cookies[i];
                            cookie.setValue("admin");
                            cookie.setMaxAge(60);
                            response.addCookie(cookie);
                            //Mandamos el mensaje al navegador        
                            response.setContentType("text/html");
                        }

                    }
                }
            } else {
                if (cookies != null) {
                    for (int i = 0; i < cookies.length; i++) {
                        if (!cookies[i].getName().equals("usuario_logueado")) {
                            c = new Cookie("usuario_logueado", "noadmin");
                            //La cookie se almacenará en el cliente por 1 minuto (60 seg)
                            c.setMaxAge(60);
                            response.addCookie(c);
                            //Mandamos el mensaje al navegador        
                            response.setContentType("text/html");
                        }else{
                            cookie = cookies[i];
                            cookie.setValue("noadmin");
                            cookie.setMaxAge(60);
                            response.addCookie(cookie);
                            //Mandamos el mensaje al navegador        
                            response.setContentType("text/html");
                        }
                    }
                }
            }
            out.println("<a href='servletPrincipal'>Comprobar login</a>");

        } finally {
            out.close();
        }
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
