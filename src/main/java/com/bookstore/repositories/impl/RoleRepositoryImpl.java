/* * Open Source Code. * */
package com.bookstore.repositories.impl;

import com.bookstore.models.RoleModel;
import com.bookstore.models.UserModel;
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
    public void create(RoleModel role) {
        List<String> file = FileUtility.read(path);
        
        file.add(toLine(role));
        
        FileUtility.write(file, path);
    }

    @Override
    public List<RoleModel> byUser(UserModel user) {
        List<String> file = FileUtility.read(path);
        
        List<RoleModel> roles = new ArrayList<>();
        
        for (String line : file) {
            RoleModel role = toRole(line);
            
            if (role.getUser().getId() == user.getId())
            {
                roles.add(role);
            }
        }
        
        return roles;
    }

    @Override
    public void delete(UserModel user, List<RoleModel> roles) {
        List<String> file = FileUtility.read(path);
        
        for (String line : file) {
            RoleModel role = toRole(line);
            
            if (role.getUser().getId() == user.getId())
            {
                file.remove(line);
            }
        }
        
        FileUtility.write(file, path);
    }

    private String toLine(RoleModel role)
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
    
    private RoleModel toRole(String line)
    {
        String[] tokens = line.split(FileUtility.stdSeparator());
           
        RoleModel role = new RoleModel();
        role.setID(Integer.parseInt(tokens[0]));
        UserModel user = new UserModel();
        user.setId(Integer.parseInt(tokens[1]));
        role.setUser(user);
        role.setGranted(Boolean.parseBoolean(tokens[2]));
        
        return role;
    }
}
