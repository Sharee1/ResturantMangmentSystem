package com.resturant.resturant_spring.contorller;


import com.resturant.resturant_spring.authservice.AuthService;
import com.resturant.resturant_spring.dto.SignupRequest;
import com.resturant.resturant_spring.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthService authService;


    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest){
        UserDTO createdUserDTO = authService.createUser(signupRequest);

        if(createdUserDTO ==null){

            return  new ResponseEntity<>("User not Created " , HttpStatus.BAD_REQUEST);

        }
       else{
            return new ResponseEntity<>(createdUserDTO, HttpStatus.CREATED);


        }



    }
}
