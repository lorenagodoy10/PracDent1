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
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "Mostrar", urlPatterns = {"/Mostrar"})
public class Mostrar extends HttpServlet {

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
       

        conexion con = new conexion();
        con.Conectar();
        
        try (PrintWriter out = response.getWriter()) {
                ControladorEmpleado bus = new ControladorEmpleado(con);
                 Empleados empleado = new Empleados();
                String idempleado = request.getParameter("idempleado");
                if (idempleado != null) {
                    System.out.println("empleado" + idempleado);
                    empleado = bus.buscar(Integer.parseInt(idempleado));
                } else {
                    System.out.println("error");
                }              
                
                
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");

            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/estilos.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            out.println("<form method = \"POST\">");
            out.println("<fieldset>");
            out.println("<legend>INFORMACION PERSONAL DEL EMPLEADO</legend>");

            out.println("<label for=\"idempleado\">IDEmpleado:</label>");
            
            out.println("<input type=\"text\" name=\"idempleado\" id=\"idempleado\" value = \""+empleado.getIdempleado()+"\">" );
            out.println("<label for=\"nombre\">Nombre:</label>");
            out.println("<input type=\"text\" name=\"nombre\" id=\"nombre\" value=\""+empleado.getNombre()+"\">" );
            out.println("<label for=\"apellido\">Apellido:</label>");
            out.println("<input type=\"text\" name=\"apellido\" id=\"apellido\" value=\""+ empleado.getApellido()+ "\"> " );
            out.println("<label for=\"celular\">Celular:</label>");
            out.println("<input type=\"text\" name=\"celular\" id=\"celular\" value = \""+ empleado.getCelular()+"\">" );
            out.println("<label for=\"direccion\">Direccion:</label>");
            out.println("<input type=\"text\" name=\"direccion\" id=\"direccion\" value=\""+ empleado.getDireccion()+"\">" );
            out.println("<label for=\"correo\">Correo:</label>");
            out.println("<input type=\"text\" name=\"correo\" id=\"correo\" value=\""+ empleado.getCorreo()+"\">" );
            out.println("<label for=\"cargo\">Cargo:</label>");
            out.println("<input type=\"text\" name=\"cargo\" id=\"cargo\" value=\""+ empleado.getCargo()+"\">" );
            out.println("<input type = \"submit\" name=\"Modificar\" value=\"Modificar\">");
            out.println("<input type = \"submit\" name=\"Eliminar\" value=\"Eliminar\">");
            out.println("<input type = \"hidden\" name=\"idempleado\" value=\""+empleado.getIdempleado()+"\">");
            out.println("</fieldset>");
            out.println("</form>");
            out.println("<form method=\"get\">");
            out.println("<input type = \"submit\" name=\"Eliminar\" value=\"Eliminar\">");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(Mostrar.class.getName()).log(Level.SEVERE, null, ex);
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
        conexion con = new conexion();
        ControladorEmpleado bsu = new ControladorEmpleado(con);
        Empleados enm = new Empleados();
        bsu.eliminar(enm);

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
 try {
            processRequest(request, response);
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String celular = request.getParameter("celular");
            String direccion = request.getParameter("direccion");
            String correo = request.getParameter("correo");
            String cargo = request.getParameter("cargo");
            String idemp = request.getParameter("idempleado");
            conexion con = new conexion();
            ControladorEmpleado ce = new ControladorEmpleado(con);
            Empleados em =  new Empleados();
            em.setNombre(nombre);
            em.setApellido(apellido);
            em.setCelular(celular);
            em.setDireccion(direccion);
            em.setCorreo(correo);
            em.setCargo(cargo);
            em.setIdempleado(Integer.parseInt(idemp));
           
		
             boolean status = ce.actualizar(em);
             if (status ) {
                System.out.println("Modificado");
            }else{
                System.out.println("No Modificado");
            }
             
        } catch (SQLException ex) {
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
