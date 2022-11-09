package com.fptu.edu.travelservices.dto.out.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackListReportOutputDto {

    private String id;

    private String comment;

    private String userId;

    private String fullName;

    private String hotelId;

    private String hotelName;

    private String statusFeedback;
}
