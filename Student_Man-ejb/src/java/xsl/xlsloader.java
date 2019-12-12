/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xsl;


import javax.ejb.Stateless;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Iterator;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFCell;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**

 */
@Stateless
public class xlsloader implements xlsloaderLocal {

    @Override
    public ResultSet xlsReader(String filename) {
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
        
        
        String sql = "INSERT INTO HistoireAcademic (code, moyenne_l_1, moyenne_l_2, moyenne_l_3,nombre_des_redoublements,nombre_des_rattrapages,nombre_des_progression,classment) VALUES (?, ?, ?, ?, ?, ?,?, ?)";


        if (conn != null) {
            System.out.println("Connected");
        }
        boolean skippedFirstRow = false;
        ResultSet rs = null;
        try
        {
            FileInputStream myInput = new FileInputStream(filename);
            POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
            HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
            HSSFSheet mySheet = myWorkBook.getSheetAt(0);
            Iterator rowIter = mySheet.rowIterator();
            rowIter.next();
            while (rowIter.hasNext())
            {
            	if (!skippedFirstRow)
                {
                    skippedFirstRow = true;
                    continue;
                }
            	PreparedStatement statement = conn.prepareStatement(sql);
            	int i = 1;
                HSSFRow myRow = (HSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                double l1 = 0.0, l2 = 0.0, l3 = 0.0;
                int r = 0, d = 0, s = 0;
                
                while (cellIter.hasNext())
                {
                	
                    HSSFCell mycell = (HSSFCell) cellIter.next();
                    
                    if(i == 1)
                    {
                    	
                        statement.setString(i, mycell.toString());
                    }
                    else if(i > 1 && i < 5)
                    {
                    	if(i == 2) l1 = mycell.getNumericCellValue();
                    	
                    	if(i == 3) l2 = mycell.getNumericCellValue();
                    		
                    	if(i == 4) l3 = mycell.getNumericCellValue();
                    	
                        statement.setDouble(i, mycell.getNumericCellValue());
                    }
                    else
                    {
                    	if(i == 5) r = Integer.parseInt(mycell.toString().substring(0,mycell.toString().length()-2));
                        	
                        if(i == 6) s = Integer.parseInt(mycell.toString().substring(0,mycell.toString().length()-2));
                        		
                        if(i == 7) d = Integer.parseInt(mycell.toString().substring(0,mycell.toString().length()-2));
                        
                        statement.setInt(i,Integer.parseInt(mycell.toString().substring(0,mycell.toString().length()-2)));
                    }
                    i += 1;
                }
                statement.setDouble(8, (((l1 + l2 + l3) / 3) * (1 - 0.04*(r + d/2 + s/6))));
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new row was inserted successfully!");
                }
            }
            Statement statement = null;
            statement = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = statement.executeQuery("SELECT * FROM HistoireAcademic");
            
        }
        catch(IOException | SQLException | NumberFormatException e)
        {
             System.out.println(e);
        }
       
		return rs;

    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
