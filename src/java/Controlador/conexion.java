/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class conexion {
    public String db = "inventario";
    public String url = "jdbc:mysql://localhost:3306/"+db;
    public String user = "root";
    public String pass = "";


   public Connection Conectar(){

       Connection link = null;

       try{

           Class.forName("com.mysql.jdbc.Driver");

           link = DriverManager.getConnection(this.url, this.user, this.pass);

       }catch(Exception ex){

           JOptionPane.showMessageDialog(null, ex);

       }


       return link;

   }
//    private static Connection cnx = null;
//   public static Connection obtener() throws SQLException, ClassNotFoundException {
//      if (cnx == null) {
//         try {
//            Class.forName("com.mysql.jdbc.Driver");
//            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventario", "root", "");
//         } catch (SQLException ex) {
//            throw new SQLException(ex);
//         } catch (ClassNotFoundException ex) {
//            throw new ClassCastException(ex.getMessage());
//         }
//      }
//      return cnx;
//   }
//   public static void cerrar() throws SQLException {
//      if (cnx != null) {
//         cnx.close();
//      }
//   }
}
