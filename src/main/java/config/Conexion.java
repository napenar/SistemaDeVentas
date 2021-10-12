/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author NORVEY
 */
public class Conexion {

    Connection con;
    String url = "jdbc:postgresql://ec2-52-87-123-108.compute-1.amazonaws.com:5432/d72pjkcnbl4vfa?sslmode=require";
    String user = "eawgjfxqpjlxgt";
    String pass = "345127d569a666b61be5f7c45f4c5f5a7c487eab38ecbdc658d161ba6b5bcb98";

    public Connection Conexion() {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("Error en la conexion: " + e);
        }
        return con;
    }

}
