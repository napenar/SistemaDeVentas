/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author NORVEY
 */
public class VentaDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;

    public String GenerarSerie() {
        String numeroserie = "";
        String sql = "select max(idventas) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                numeroserie = rs.getString(1);
            }
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en VentaDAO generarserie " + e);
        }
        return numeroserie;

    }
    
    public String idVentas(){
        String idventas = "";
        String sql = "select max(idventas) from ventas";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idventas = rs.getString(1);
            }
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en VentaDAO idVentas " + e);
        }
        return idventas;
    }
    
    public int guardarVenta(Venta ve){
        String sql = "insert into ventas(idcliente,idempleado,numeroserie,fechaventas,monto,estado) values(?,?,?,?,?,?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ve.getIdcliente());
            ps.setInt(2, ve.getIdempleado());
            ps.setString(3, ve.getNumserie());
            ps.setDate(4, Date.valueOf(ve.getFecha()));
            ps.setDouble(5, ve.getPrecio());
            ps.setString(6, ve.getEstado());
            r=ps.executeUpdate();
            ps.close();
            cn.getCon().close();
        } catch (Exception e) {
            System.out.println("Error en VentaDAO guardarventa " + e);
        }
        return r;
    }
    
    public int guardarDetalventas(Venta venta){
        String sql = "insert into detalle_ventas(idventas,idproducto,cantidad,precioventa) values(?,?,?,?)";
        try {
            con=cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setInt(1, venta.getId());
            ps.setInt(2, venta.getIdproducto());
            ps.setInt(3, venta.getCantidad());
            ps.setDouble(4, venta.getPrecio());
            r = ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

}
