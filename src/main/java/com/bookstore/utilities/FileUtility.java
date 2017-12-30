/** Open Source code **/
package com.bookstore.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author derickfelix
 * @Date 12/30/17
 */
public class FileUtility {
    
    public static String stdSeparator()
    {
        return ";";
    }
    
    public static void createDirectory(String... dirs)
    {
        File file;
        for (String dir : dirs)
        {
            file = new File(dir);
            file.mkdir();
        }
    }
    
    public static void createFile(String fileName)
    {
        try {
            File file = new File(fileName);
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    public static void write(List<String> file, String fileName)
    {
        try (PrintWriter writer = new PrintWriter(fileName))
        {
            
            for (String line : file)
            {
                writer.write(line);
            }
            
            writer.flush();
        } 
        catch (IOException e) 
        {
            System.err.printf("An error occurred when writing in %s\n%s\n", fileName, e);
        }
    }
    
    public static List<String> read(String fileName)
    {
        List<String> file = new ArrayList<>();
        
        try (FileReader fileReader = new FileReader(fileName);
                BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            
            String line = bufferedReader.readLine();
            
            while (line != null)
            {
                file.add(line);
                line = bufferedReader.readLine();
            }
            
        } catch (IOException e) {
            System.err.printf("An error occurred when reading file in %s\n%s\n", fileName, e);
        }
        
        return file;
    }
}
