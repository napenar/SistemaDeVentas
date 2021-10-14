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
public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Cliente validar(String dni) {
        Cliente cl = new Cliente();
        String sql = "select * from cliente where dni = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDir(rs.getString(4));
                cl.setEstado(rs.getString(5));
            }
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error Conexion en ClienteDAO " + e);
        }
        return cl;
    }

    public Cliente buscar(String dni) {
        Cliente c = new Cliente();
        String sql = "select * from cliente where dni=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, dni);
            rs = ps.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setDni(rs.getString(2));
                c.setNom(rs.getString(3));
                c.setDir(rs.getString(4));
                c.setEstado(rs.getString(5));
            }
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en ClienteDAO buscar " + e);
        }
        return c;
    }

    //OPERACIONES CRUD
    public List listar() {
        String sql = "select * from cliente";
        List<Cliente> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getInt(1));
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDir(rs.getString(4));
                cl.setEstado(rs.getString(5));
                lista.add(cl);
            }
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en listar ClienteDAO " + e);
        }
        return lista;
    }

    public int agregar(Cliente cl) {
        String sql = "insert into cliente(dni,nombres,direccion,estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDir());
            ps.setString(4, cl.getEstado());
            r = ps.executeUpdate();
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en agregar en ClienteDAO " + e);
        }
        return r;
    }

    public Cliente listarId(int id) {
        Cliente cl = new Cliente();
        String sql = "select * from cliente where idcliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cl.setDni(rs.getString(2));
                cl.setNom(rs.getString(3));
                cl.setDir(rs.getString(4));
                cl.setEstado(rs.getString(5));
            }
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en ClienteDAO listarID " + e);
        }
        return cl;
    }

    public int actualizar(Cliente cl) {
        String sql = "update cliente set dni=?,nombres=?,direccion=?,estado=? where idcliente=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNom());
            ps.setString(3, cl.getDir());
            ps.setString(4, cl.getEstado());
            ps.setInt(5, cl.getId());
            r = ps.executeUpdate();
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en actualizar en ClienteDAO " + e);
        }
        return r;

    }

    public void delete(int id) {
        String sql = "delete from cliente where idcliente=" + id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en eliminar en ClienteDAO " + e);
        }
    }
}
