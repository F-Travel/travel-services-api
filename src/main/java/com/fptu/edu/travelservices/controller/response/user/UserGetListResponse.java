package com.fptu.edu.travelservices.controller.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGetListResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("user_name")
    private String username;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("address")
    private String address;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("user_status")
    private String userStatus;
}
