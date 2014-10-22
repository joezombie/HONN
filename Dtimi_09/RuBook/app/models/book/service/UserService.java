package models.book.service;

import models.book.data.UserDTO;

import java.util.List;

/**
 * Created by Johannes Gunnar Heidarsson on 22.10.2014.
 */
public interface UserService {
    public List<UserDTO> getUsers();

    UserDTO getUser(int id);
}
