package com.fptu.edu.travelservices.dto.in.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackInputDto {

    private String hotelId;

    private String userId;

    private String starPoint;

    private String comment;
}
