/** Open Source code **/
package com.bookstore.utilities;

/**
 *
 * @author derickfelix
 * @Date 12/30/17
 */
public class DirectoryUtility {
    
    private static final String HOME_DIR = "/home/derickfelix/bookstore";
    
    public static String USER_FILE()
    {
        String dir = HOME_DIR + "/datas/";
        String file = dir + "users.data";
        
        return create(file, dir);
    }
    
    private static String create(String file, String dir)
    {
        FileUtility.createDirectory(HOME_DIR, dir);
        FileUtility.createFile(file);
        
        return file;
    }
   
}
