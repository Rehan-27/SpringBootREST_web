package rehan.spring.restwebservices.rehanrest.service.impl;


import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import rehan.spring.restwebservices.rehanrest.DTO.UserDTO;
import rehan.spring.restwebservices.rehanrest.entity.User;
import rehan.spring.restwebservices.rehanrest.exception.EmailAlreadyExistsException;
import rehan.spring.restwebservices.rehanrest.exception.ResourceNotFoundException;
import rehan.spring.restwebservices.rehanrest.repository.UserRepository;
import rehan.spring.restwebservices.rehanrest.service.UserService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    //Model mapper dependency for conversion
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDto) {

        Optional<User> optionalUser= userRepository.findByEmail(userDto.getEmail());

        if(optionalUser.isPresent()){
            throw new EmailAlreadyExistsException("Email Already Exists.");
        }

        //Converting userDTO object to user JPA object
        //User user= UserMapper.convertToUser(userDto);
        User user= modelMapper.map(userDto, User.class);
        //saving in DB
        User savedUser= userRepository.save(user);
        //Converting JPA to DTO
        //return UserMapper.convertToDTO(savedUser);
        return modelMapper.map(savedUser,UserDTO.class);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).
                                            orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        //Converting to DTO bedore returning
        //return UserMapper.convertToDTO(user);
        return modelMapper.map(user,UserDTO.class);
    }

    public List<UserDTO> getAllUsers() {
        List<User> usersfromDB=userRepository.findAll();
        //Converting to DTO list
//        List<UserDTO> allUsers= usersfromDB.stream()
//                                            .map(UserMapper::convertToDTO)
//                                            .collect(Collectors.toList());
        List<UserDTO> allUsers= usersfromDB.stream()
                                            .map((user)->modelMapper.map(user,UserDTO.class))
                                            .collect(Collectors.toList());
        return allUsers;
    }

    @Override
    public UserDTO updateUserById(Long id,UserDTO userDto) {
        //checking if user exists or else throw exception
        User existingUser = userRepository.findById(id)
                                        .orElseThrow(()->new ResourceNotFoundException("User","id",id));
        existingUser.setFirstName(userDto.getFirstName());
        existingUser.setLastName(userDto.getLastName());
        existingUser.setEmail(userDto.getEmail());
        User updatedUser = userRepository.save(existingUser);
        //Converting user entity to DTO
        //return UserMapper.convertToDTO(updatedUser);
        return modelMapper.map(updatedUser,UserDTO.class);
    }

    @Override
    public void deleteUserById(Long id) {
        //checking if user exists or else throw exception
        User existingUser = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User","id",id));
        userRepository.deleteById(id);
    }
}