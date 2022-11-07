package com.fptu.edu.travelservices.dto.out.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailOutputDto {

    private String id;

    private String fullName;

    private String email;

    private String phone;

    private String address;

    private String birthday;

    private String avatar;
}
