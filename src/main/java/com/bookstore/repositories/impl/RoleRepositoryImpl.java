/* * Open Source Code. * */
package com.bookstore.repositories.impl;

import com.bookstore.models.Role;
import com.bookstore.models.User;
import com.bookstore.repositories.RoleRepository;
import com.bookstore.utilities.DirectoryUtility;
import com.bookstore.utilities.FileUtility;
import java.util.ArrayList;
import java.util.List;

/**
 * @Date: Jan 2, 2018
 * @author Derick Felix
 */
public class RoleRepositoryImpl implements RoleRepository {

    private final String path;

    public RoleRepositoryImpl() {
        this.path = DirectoryUtility.ROLE_FILE();
    }

    @Override
    public void create(Role role) {
        List<String> file = FileUtility.read(path);
        
        file.add(toLine(role));
        
        FileUtility.write(file, path);
    }

    @Override
    public List<Role> byUser(User user) {
        List<String> file = FileUtility.read(path);
        
        List<Role> roles = new ArrayList<>();
        
        for (String line : file) {
            Role role = toRole(line);
            
            if (role.getUser().getId() == user.getId())
            {
                roles.add(role);
            }
        }
        
        return roles;
    }

    @Override
    public void delete(User user, List<Role> roles) {
        List<String> file = FileUtility.read(path);
        
        for (String line : file) {
            Role role = toRole(line);
            
            if (role.getUser().getId() == user.getId())
            {
                file.remove(line);
            }
        }
        
        FileUtility.write(file, path);
    }

    private String toLine(Role role)
    {
        List<String> fields = new ArrayList<>();
        
        fields.add(role.getID() + FileUtility.stdSeparator());
        fields.add(role.getUser().getId() + FileUtility.stdSeparator());
        fields.add(role.isGranted() + FileUtility.stdSeparator());
        
        String line = "";
        
        for (String field : fields)
        {
            line += field;
        }
        
        return line;
    }
    
    private Role toRole(String line)
    {
        String[] tokens = line.split(FileUtility.stdSeparator());
           
        Role role = new Role();
        role.setID(Integer.parseInt(tokens[0]));
        User user = new User();
        user.setId(Integer.parseInt(tokens[1]));
        role.setUser(user);
        role.setGranted(Boolean.parseBoolean(tokens[2]));
        
        return role;
    }
}
