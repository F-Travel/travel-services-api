package com.fptu.edu.travelservices.controller.request.feedback;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackRequest {

    @JsonProperty(value = "hotel_id")
    private String hotelId;

    @JsonProperty(value = "user_id")
    private String userId;

    @JsonProperty(value = "star_point")
    private String starPoint;

    @JsonProperty(value = "comment")
    private String comment;
}
