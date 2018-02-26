/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controlador.Empleados;
import Controlador.conexion;
import Modelo.ControladorEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Empleado", urlPatterns = {"/Empleado"})
public class Empleado extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Empleado</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilos.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<form  method =\"post\" action=\"Empleado\">");
            out.println("<fieldset>");
            out.println("<legend>INFORMACION PERSONAL DEL EMPLEADO</legend>");
             out.println("<label for=\"idempleado\">IDEmpleado:</label>");
            out.println("<input type=\"text\" name=\"idempleado\" id=\"idempleado\">");
            out.println("<label for=\"nombre\">Nombre:</label>");
            out.println("<input type=\"text\" name=\"nombre\" id=\"nombre\">");
            out.println("<label for=\"apellido\">Apellido:</label>");
            out.println("<input type=\"text\" name=\"apellido\" id=\"apellido\">");
            out.println("<label for=\"celular\">Celular:</label>");
            out.println("<input type=\"text\" name=\"celular\" id=\"celular\">");
            out.println("<label for=\"direccion\">Direccion:</label>");
            out.println("<input type=\"text\" name=\"direccion\" id=\"direccion\">");
            out.println("<label for=\"correo\">Correo:</label>");
            out.println("<input type=\"text\" name=\"correo\" id=\"correo\">");
            out.println("<label for=\"cargo\">Cargo:</label>");
            out.println("<input type=\"text\" name=\"cargo\" id=\"cargo\">");
            out.println("<input type=\"submit\" name=\"Enviar\" value=\"Enviar\">");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
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
        try {
            processRequest(request, response);
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String celular = request.getParameter("celular");
            String direccion = request.getParameter("direccion");
            String correo = request.getParameter("correo");
            String cargo = request.getParameter("cargo");
            conexion con = new conexion();
            ControladorEmpleado ce = new ControladorEmpleado(con);
            Empleados em =  new Empleados();
            em.setNombre(nombre);
            em.setApellido(apellido);
            em.setCelular(celular);
            em.setDireccion(direccion);
            em.setCorreo(correo);
            em.setCargo(cargo);
            boolean status = ce.insertar(em);
            if (status) {
                System.out.println("Registrado");
            }else{
                System.out.println("No Registrado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
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
