/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nomina;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pc
 */
@WebServlet(name = "serv_Menu_Nomina", urlPatterns = {"/serv_Menu_Nomina"})
public class serv_Menu_Nomina extends HttpServlet {

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
        String is_pantalla = "";
        String is_boton = "";
        is_boton = request.getParameter("boton");

        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaMenuNomina();
        }

        if (is_boton != null && is_boton != "") {

            if (is_boton.equals("Motivos")) {
                is_pantalla = desplegarPantallaMenuNomina() + ("<p style=\"color: #F6DAD4\">Motivos</p>");
            }
            if (is_boton.equals("Empleados")) {
                is_pantalla = desplegarPantallaMenuNomina() + ("<p style=\"color: #F6DAD4\">Empleados</p>");
            }
            if (is_boton.equals("Nomina")) {
                is_pantalla = desplegarPantallaMenuNomina() + ("<p style=\"color: #F6DAD4\">Nómina</p>");
            }
            if (is_boton.equals("Reportes")) {
                is_pantalla = desplegarPantallaMenuNomina() + ("<p style=\"color: #F6DAD4\">Reportes</p>");
            }
            if (is_boton.equals("Regresar")) {
                is_pantalla = desplegarPantallaMenuNomina() + ("<p style=\"color: #F6DAD4\">Regresar</p>");
            }
        }
        out.println(is_pantalla);

    }

    public String desplegarPantallaMenuNomina() {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_Menu_Nomina</title>");
        ls_pantalla += "<style type='text/css'>";
        ls_pantalla += "";//Aqui va el css
        ls_pantalla += "</style>";
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += "<h1>Menú Nómina</h1>";
        ls_pantalla += "<a href='http://localhost:9090/distribuidas/serv_Motivos'><input type='submit' name='boton' value='Motivos'></a>";
        ls_pantalla += "</br>";
        ls_pantalla += "<a href='http://localhost:9090/distribuidas/serv_Empleados'><input type='submit' name='boton' value='Empleados'></a>";
        ls_pantalla += "</br>";
        ls_pantalla += "<a href=''><input type='submit' name='boton' value='Nómina'></a>";
        ls_pantalla += "</br>";
        ls_pantalla += ("<input type='submit' value='Reportes' name='boton' ></input>");
        ls_pantalla += "</br>";
        ls_pantalla += ("<a href='http://localhost:9090/distribuidas/serv_menu'><input type='submit' value='Regresar' name='boton' ></a>");
        ls_pantalla += ("</body>");
        ls_pantalla += ("</html>");
        return ls_pantalla;

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
