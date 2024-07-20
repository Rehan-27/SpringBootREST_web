package rehan.spring.restwebservices.rehanrest.service;

import rehan.spring.restwebservices.rehanrest.DTO.UserDTO;
import rehan.spring.restwebservices.rehanrest.entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDto);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUserById(Long id,UserDTO userDto);

    void deleteUserById(Long id);
}
