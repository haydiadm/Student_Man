/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uploader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *

 */
@Stateless
public class uploader implements uploaderLocal {

    @Override
    public String uploadHandler(HttpServletRequest request, HttpServletResponse response) {
        try {
            Part filePart = request.getPart("xls_file"); // Retrieves <input type="file" name="xls_file">
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();
            // ... (do your job here)
            //Read an Excel File and Store in a Vector
            
            // get uploads directory
            String sep = File.separator;
            String dirName;
            if(sep.equals("/"))
            {
                // we are on linux
                dirName = (new File("/home/lenny")).getAbsolutePath() + "/Desktop/uploads";
            }
            else
            {
                // we are on windows so Haydi you should add a path to folder on your desktop here
                dirName = "E:\\hway kano f bureau\\uploads";
                
            }
            
            File uploads = new File(dirName);
            System.out.println(uploads.getAbsolutePath());
            
            
            
            // store file
            
            File file = new File(uploads, "document.xls");
            if(!file.exists())
            {
                file.createNewFile();
            }
            byte[] buffer = new byte[fileContent.available()];
            fileContent.read(buffer);
            
            OutputStream os = new FileOutputStream(file);
            os.write(buffer);
            return file.getAbsolutePath();
        } catch (IOException ex) {
            System.out.println(ex);
            Logger.getLogger(uploader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServletException ex) {
             System.out.println(ex);
            Logger.getLogger(uploader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
