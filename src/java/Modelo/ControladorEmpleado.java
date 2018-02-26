/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Empleados;
import Controlador.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class ControladorEmpleado {

    private conexion con;

    public ControladorEmpleado(conexion con) {
        this.con = con;
    }

    public boolean insertar(Empleados empleado) throws SQLException, ClassNotFoundException {
        conexion con;
        con = new conexion();
        try {
            String sql = "INSERT INTO empleado(idempleado,nombre,apellido,celular,direccion,correo,cargo) VALUES (?,?,?,?,?,?,?)";
            con.Conectar();
            PreparedStatement statement = con.Conectar().prepareStatement(sql);
            statement.setString(1, null);
            statement.setString(2, empleado.getNombre());
            statement.setString(3, empleado.getApellido());
            statement.setString(4, empleado.getCelular());
            statement.setString(5, empleado.getDireccion());
            statement.setString(6, empleado.getCorreo());
            statement.setString(7, empleado.getCargo());
            statement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public Empleados buscar(int idempleado) throws SQLException {

        conexion con;
        con = new conexion();
        try {
            Empleados empleado = new Empleados();
            String sql = "SELECT  * FROM empleado WHERE idempleado=" + idempleado;
            con.Conectar();
            PreparedStatement ps = con.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next() == true) {
                empleado.setIdempleado(rs.getInt("idempleado"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setCelular(rs.getString("celular"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setCorreo(rs.getString("correo"));
                empleado.setCargo(rs.getString("cargo"));
                return empleado;
            } else {
                return null;
            }

        } catch (Exception e) {
            return null;
        }
    }

    public boolean actualizar(Empleados empleado1) throws SQLException {
        boolean actualiza;
        conexion con;
        con = new conexion();
        try {
            String sql = "UPDATE empleado SET nombre=?,apellido=?,celular=?,direccion=?,correo=?,cargo=? WHERE idempleado=?";

            con.Conectar();
            PreparedStatement statement = con.Conectar().prepareStatement(sql);

            statement.setString(1, empleado1.getNombre());
            statement.setString(2, empleado1.getApellido());
            statement.setString(3, empleado1.getCelular());
            statement.setString(4, empleado1.getDireccion());
            statement.setString(5, empleado1.getCorreo());
            statement.setString(6, empleado1.getCargo());
            statement.setInt(7, empleado1.getIdempleado());
            actualiza = statement.executeUpdate() > 0;
            return actualiza;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(Empleados empleado2) {
        boolean elimina;
        conexion con;
        con = new conexion();
        try {
            String sql = "DELETE FROM empleado WHERE idempleado = ?";            
            PreparedStatement statement = con.Conectar().prepareStatement(sql);
            statement.setInt(1, empleado2.getIdempleado());
            elimina = statement.executeUpdate()>0;
            return elimina;
        } catch (Exception e) {
            
        }
        return false;
    }
}
