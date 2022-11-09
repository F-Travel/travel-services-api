package com.fptu.edu.travelservices.controller.response.feedback;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackListReportResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("hotel_id")
    private String hotelId;

    @JsonProperty("hotel_name")
    private String hotelName;

    @JsonProperty("status_feedback")
    private String statusFeedback;
}
