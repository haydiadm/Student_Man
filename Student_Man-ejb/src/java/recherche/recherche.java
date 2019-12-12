/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recherche;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import xsl.xlsloader;

/**
 *
 * @author lenny
 */
@Stateless
public class recherche implements rechercheLocal {

    @Override
    public ResultSet rechercher(String code) {
        try {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            }
            catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                System.out.println(e);
            } catch (InstantiationException ex) {
                Logger.getLogger(xlsloader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(xlsloader.class.getName()).log(Level.SEVERE, null, ex);
            }
            String dbURL = "jdbc:mysql://localhost:3306/Etudiants?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useTimeZone=true&autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "root";
            Connection conn = null;
            try
            {
                conn = DriverManager.getConnection(dbURL, username, password);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            if (conn != null) {
                System.out.println("Connected");
            }
            
            ResultSet rs = null;
            Statement statement = null;
            statement = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            try {
                rs = statement.executeQuery("SELECT * FROM HistoireAcademic WHERE code = '" + code + "'");
            } catch (SQLException ex) {
                Logger.getLogger(recherche.class.getName()).log(Level.SEVERE, null, ex);
            }
            return rs;
        } 
        catch (SQLException ex) {
            Logger.getLogger(recherche.class.getName()).log(Level.SEVERE, null,ex);
        } 
        return null;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
