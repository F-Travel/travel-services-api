package com.fptu.edu.travelservices.controller.response.feedback;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackResponse {

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("star_point")
    private int starPoint;

    @JsonProperty("user_name")
    private String userName;

    @JsonProperty("avatar")
    private String avatar;
}
