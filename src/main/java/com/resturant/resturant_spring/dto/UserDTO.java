package com.resturant.resturant_spring.dto;

import com.resturant.resturant_spring.enums.UserRole;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {

    private Long id;
    private String name;
    private String userName;
    private String email;


    private UserRole userRole;
}
