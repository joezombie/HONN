package models.book.service;

import models.book.data.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 22.10.2014.
 */
public class UserServiceStub implements UserService {
    protected List<UserDTO> userList;
    public UserServiceStub() {
        this.userList = new ArrayList<UserDTO>();

        userList.add(new UserDTO(1, "Boris Badenov", "boris", "boris@pottsylvania.gov"));
        userList.add(new UserDTO(2, "Natasha Fatale", "natasha", "natasha@pottsylvania.gov"));
        userList.add(new UserDTO(3, "Rocky J. Squirrel", "rocky", "rocky@internationalfalls.gov"));
        userList.add(new UserDTO(4, "Bullwinkle J. Moose", "bullwinkle", "bullwinkle@internationalfalls.gov"));
    }


    @Override
    public List<UserDTO> getUsers() {
        return userList;
    }

    @Override
    public UserDTO getUser(int id) {
        for(UserDTO u : userList){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }
}
