package com.resturant.resturant_spring.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class SignupRequest {

    private String name;
    private String userName;
    private String password;
    private String email;
}
