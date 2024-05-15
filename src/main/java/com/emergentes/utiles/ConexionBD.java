package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/bd_internet";
    static String usuario = "root";
    static String clave = "";
    
    Connection con = null;

    public ConexionBD() {
        
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, usuario, clave);
            if (con != null) {
                System.out.println("Conexión OK:"+con);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection conectar() {
        return con;
    }
    
    public void desconectar() {
        try { con.close();} catch (SQLException e) {
            System.out.println("Error al cerrar la conexion:"+e);
        }
    }
    
    
}
