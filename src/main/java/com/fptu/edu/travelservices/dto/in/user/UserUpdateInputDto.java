package com.fptu.edu.travelservices.dto.in.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateInputDto {

    private String fullName;

    private String phone;

    private String address;

    private String birthday;

    private String avatar;
}
