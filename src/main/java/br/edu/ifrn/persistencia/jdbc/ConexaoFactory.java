package br.edu.ifrn.persistencia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

class ConexaoFactory {

    public static Connection getConnection()  {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/fabricaweb","postgres","mh22xx");
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoFactory.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
}
