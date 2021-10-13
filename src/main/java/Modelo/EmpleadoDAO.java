/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NORVEY
 */
public class EmpleadoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Empleado validar(String user, String dni) {
        Empleado em = new Empleado();
        String sql = "select * from empleado where usuario = ? and dni = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setUser(rs.getString("usuario"));
                em.setDni(rs.getString("dni"));
                em.setNom(rs.getString("nombres"));
                em.setId(rs.getInt("idempleado"));
            }
        } catch (Exception e) {
            System.out.println("Error Conexion en empleadoDAO " + e);
        }
        return em;
    }

    //OPERACIONES CRUD
    public List listar() {
        String sql = "select * from empleado";
        List<Empleado> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado em = new Empleado();
                em.setId(rs.getInt(1));
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
                lista.add(em);
            }
        } catch (Exception e) {
            System.out.println("Error en listar EmpleadoDAO " + e);
        }
        return lista;
    }

    public int agregar(Empleado em) {
        String sql = "insert into empleado(dni,nombres,telefono,estado,usuario) values(?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en agregar en EmpleadoDAO " + e);
        }
        return r;
    }

    
    public Empleado listarId(int id){
        Empleado em = new Empleado();
        String sql = "select * from empleado where idempleado="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                em.setDni(rs.getString(2));
                em.setNom(rs.getString(3));
                em.setTel(rs.getString(4));
                em.setEstado(rs.getString(5));
                em.setUser(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return em;
    }
    
    public int actualizar(Empleado em) {
        String sql = "update empleado set dni=?,nombres=?,telefono=?,estado=?,usuario=? where idempleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getDni());
            ps.setString(2, em.getNom());
            ps.setString(3, em.getTel());
            ps.setString(4, em.getEstado());
            ps.setString(5, em.getUser());
            ps.setInt(6, em.getId());
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en actualizar en EmpleadoDAO " + e);
        }
        return r;

    }

    public void delete(int id) {
        String sql = "delete from empleado where idempleado=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en eliminar en EmpleadoDAO " + e);
        }
    }
}
