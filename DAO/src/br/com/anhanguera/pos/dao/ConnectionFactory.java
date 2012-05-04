package br.com.anhanguera.pos.dao;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rafaelpoveda
 */
public class ConnectionFactory {
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost/engsw","root","");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
