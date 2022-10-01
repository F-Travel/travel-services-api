package com.fptu.edu.travelservices.dto.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInputDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phone;

    private String address;

    private String interests;

}
