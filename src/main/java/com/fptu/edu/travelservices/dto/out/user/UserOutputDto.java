package com.fptu.edu.travelservices.dto.out.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOutputDto {

    private String id;

    private String username;

    private String fullName;

    private String email;

    private String phone;

    private String address;

    private String avatar;

    private String birthday;

    private String userStatus;
}
