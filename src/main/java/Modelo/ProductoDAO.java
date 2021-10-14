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
public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public Producto validar(String id) {
        Producto pd = new Producto();
        String sql = "select * from producto where idproducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                pd.setId(rs.getInt(1));
                pd.setNom(rs.getString(2));
                pd.setPrecio(rs.getDouble(3));
                pd.setStock(rs.getInt(4));
                pd.setEstado(rs.getString(5));
            }
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error Conexion en ProductoDAO " + e);
        }
        return pd;
    }

    //OPERACIONES CRUD
    public List listar() {
        String sql = "select * from producto";
        List<Producto> lista = new ArrayList<>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto pd = new Producto();
                pd.setId(rs.getInt(1));
                pd.setNom(rs.getString(2));
                pd.setPrecio(rs.getDouble(3));
                pd.setStock(rs.getInt(4));
                pd.setEstado(rs.getString(5));
                lista.add(pd);
            }
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en listar ProductoDAO " + e);
        }
        return lista;
    }

    public int agregar(Producto pd) {
        String sql = "insert into producto(nombres,precio,stock,estado) values(?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pd.getNom());
            ps.setDouble(2, pd.getPrecio());
            ps.setInt(3, pd.getStock());
            ps.setString(4, pd.getEstado());
            r = ps.executeUpdate();
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en agregar en ProductoDAO " + e);
        }
        return r;
    }

    
    public Producto listarId(int id){
        Producto pd = new Producto();
        String sql = "select * from producto where idproducto="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                pd.setId(rs.getInt(1));
                pd.setNom(rs.getString(2));
                pd.setPrecio(rs.getDouble(3));
                pd.setStock(rs.getInt(4));
                pd.setEstado(rs.getString(5));
            }
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en ProductoDAO listarID " + e);
        }
        return pd;
    }
    
    public int actualizar(Producto pd) {
        String sql = "update producto set nombres=?,precio=?,stock=?,estado=? where idproducto=?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, pd.getNom());
            ps.setDouble(2, pd.getPrecio());
            ps.setInt(3, pd.getStock());
            ps.setString(4, pd.getEstado());
            ps.setInt(5, pd.getId());
            r = ps.executeUpdate();
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en actualizar en ProductoDAO " + e);
        }
        
        return r;

    }

    public void delete(int id) {
        String sql = "delete from producto where idproducto="+id;
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en eliminar en ProductoDAO " + e);
        }
    }
}
