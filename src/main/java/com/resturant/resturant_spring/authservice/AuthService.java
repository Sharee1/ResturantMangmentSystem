package com.resturant.resturant_spring.authservice;

import com.resturant.resturant_spring.dto.SignupRequest;
import com.resturant.resturant_spring.dto.UserDTO;

public interface AuthService {



    UserDTO createUser(SignupRequest signupRequest);
}
