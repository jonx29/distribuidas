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
@WebServlet(name = "serv_Empleados", urlPatterns = {"/serv_Empleados"})
public class serv_Empleados extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String ls_mensaje = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        //try (PrintWriter out = response.getWriter()) {
        String is_pantalla = "";

        String is_boton = "";
        String nombre = "";
        String cedula = "";
        String FechaIngreso = "";
        String sueldo = "";

        is_boton = request.getParameter("boton");

        if (is_boton == null || is_boton == "") {
            is_pantalla = desplegarPantallaEmpleados("","","","");

        }
        if (is_boton != null && is_boton != "") {

            cedula = request.getParameter("cedula");
            nombre = request.getParameter("nombre");
            FechaIngreso = request.getParameter("FechaIngreso");
            sueldo = request.getParameter("sueldo");

            if (is_boton.equals("Insertar")) {
                /* ls_mensaje = nombre + " Insertado a la cuenta " + cuenta + " y tipo de cuenta: " + tipo_cuenta;*/
            }
            if (is_boton.equals("Modificar")) {
                ls_mensaje = "Modificar";
            }
            if (is_boton.equals("Guardar")) {
                ls_mensaje = "Guardar";
            }
            if (is_boton.equals("Buscar")) {
                ls_mensaje = "Buscar";
            }
            if (is_boton.equals("Eliminar")) {
                ls_mensaje = "Eliminar";
            }
            if (is_boton.equals("Regresar")) {
                ls_mensaje = "Regresar";
            }
            is_pantalla = desplegarPantallaEmpleados("", "", "","") + ls_mensaje;
        }
        out.println(is_pantalla);
    }

    public String desplegarPantallaEmpleados(String ls_nombre, String ls_cedula, String ls_sueldo, String ls_FechaIngreso) {
        String ls_pantalla = "";
        ls_pantalla += ("<!DOCTYPE html>");
        ls_pantalla += ("<html>");
        ls_pantalla += ("<head>");
        ls_pantalla += ("<title>Servlet serv_Empleados</title>");
        ls_pantalla += ("</head>");
        ls_pantalla += ("<body>");
        ls_pantalla += ("<h1>Empleados</h1>");
        ls_pantalla += ("<form action='serv_Empleados' method='post'>");

        ls_pantalla += ("Nombre:<input type='text' name='nombre' required='required'" + " value='" + ls_nombre + "'></input>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("CI:<input type='text' name='cedula' required='required'" + " value='" + ls_cedula + "'></input>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Fecha de Ingreso:<input type='text' name='FechaIngreso' required='required'" + " value='" + ls_FechaIngreso + "'></input>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("Sueldo:<input type='text' name='sueldo' required='required'" + " value='" + ls_sueldo + "'></input>");

        ls_pantalla += ("</br>");
      /*  ls_pantalla += ("Cédula: <select id='cedula' name='cedula'>");
        for (int i = 0; i < 5; i++) {
            ls_pantalla += ("<option  value=cedula_" + i + ">Cédula No. " + i + "</option>");
        }**/
        ls_pantalla += ("</select>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("</br>");
        ls_pantalla += ("<input type='submit' value='Insertar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Guardar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Modificar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Buscar' name='boton' ></input>");
        ls_pantalla += ("<input type='submit' value='Eliminar' name='boton' ></input>");
        ls_pantalla += ("</br>");

        ls_pantalla += "</form>";
        ls_pantalla += ("<a href='http://localhost:9090/distribuidas/serv_Menu_Contabilidad'><input type='submit' value='Regresar' name='boton' ></a>");
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
