/** Open Source code **/
package com.bookstore.repositories.impl;

import com.bookstore.models.User;
import com.bookstore.repositories.UserRepository;
import com.bookstore.utilities.DirectoryUtility;
import com.bookstore.utilities.FileUtility;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author derickfelix
 * @Date 12/30/17
 */
public class UserRepositoryImpl implements UserRepository {

    private final String path;
    private List<User> users;
    
    public UserRepositoryImpl()
    {
        this.path = DirectoryUtility.USER_FILE();
    }
    
    @Override
    public List<User> all()
    {
        List<String> file = FileUtility.read(path);
        
        if (users == null)
            users = new ArrayList<>();
        else
            users.clear();
        
        for (String line : file)
            users.add(toUser(line));
        
        return users;
    }

    @Override
    public void add(User user) {
        List<String> file = FileUtility.read(path);
        
        file.add(toLine(user));
        
        FileUtility.write(file, path);
    }

    @Override
    public User find(int id) {
        List<String> file = FileUtility.read(path);
        
        for (String line : file)
        {
            User user = toUser(line);
            
            if (user.getId() == id)
                return user;
        }
        
        return null;
    }

    @Override
    public void delete(User user) {
        List<String> file = FileUtility.read(path);
        
        for (String line : file)
        {
            if (line.contains(user.getEmail()) 
                    && line.contains(user.getPassword()))
                file.remove(line);
        }
        
        FileUtility.write(file, path);
    }
    
    
    private String toLine(User user)
    {
        List<String> fields = new ArrayList<>();
        
        fields.add(user.getId() + FileUtility.stdSeparator());
        fields.add(user.getName() + FileUtility.stdSeparator());
        fields.add(user.getEmail() + FileUtility.stdSeparator());
        fields.add(user.getPassword() + FileUtility.stdSeparator()); // dangerous (psw uncrypted))
        
        String line = "";
        
        for (String field : fields)
        {
            line += field;
        }
        
        return line;
    }
    
    private User toUser(String line)
    {
        String[] tokens = line.split(FileUtility.stdSeparator());
        
        User user = new User();
        user.setId(Integer.parseInt(tokens[0]));
        user.setName(tokens[1]);
        user.setEmail(tokens[2]);
        user.setPassword(tokens[3]);
        
        return user;
    }
}
