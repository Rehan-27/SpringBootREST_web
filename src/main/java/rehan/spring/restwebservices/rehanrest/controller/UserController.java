package rehan.spring.restwebservices.rehanrest.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rehan.spring.restwebservices.rehanrest.DTO.UserDTO;
import rehan.spring.restwebservices.rehanrest.service.UserService;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {


    private UserService userService;


    //Build REST API for Creating user in DB
    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDto){
        UserDTO savedUser= userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    //Build REST API for getting user from DB
    @GetMapping("/getUserById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id){
        UserDTO userFromDB= userService.getUserById(id);
        return new ResponseEntity<>(userFromDB, HttpStatus.OK);
    }

    //Build REST API for getting all the users from DB
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        List<UserDTO> allUsersFromDB=userService.getAllUsers();
        return new ResponseEntity<>(allUsersFromDB, HttpStatus.OK);
    }

    //Build REST API for updating the user by id from DB
    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody @Valid UserDTO userDto){
        UserDTO updatedUser= userService.updateUserById(id,userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Build REST API for deleting the user by id from DB
    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        String result= "User with id "+id+" deleted successfully.";
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
