package com.resturant.resturant_spring.authservice;


import com.resturant.resturant_spring.dto.SignupRequest;
import com.resturant.resturant_spring.dto.UserDTO;
import com.resturant.resturant_spring.entities.User;
import com.resturant.resturant_spring.enums.UserRole;
import com.resturant.resturant_spring.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{


    private UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDTO createUser(SignupRequest signupRequest) {

        User user = new User();
        user.setUserName(signupRequest.getUserName());
        user.setName(signupRequest.getName());
        user.setEmail(signupRequest.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(signupRequest.getPassword()));
        user.setUserRole(UserRole.customer);
        User CreatedUser = userRepository.save(user);

        UserDTO createUserDto =new UserDTO();
        createUserDto.setId(CreatedUser.getId());
        createUserDto.setUserName(CreatedUser.getUserName());
        createUserDto.setName(CreatedUser.getName());
        createUserDto.setEmail(CreatedUser.getEmail());
        createUserDto.setUserRole(CreatedUser.getUserRole());

        return createUserDto;




    }
}
