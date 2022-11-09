package com.fptu.edu.travelservices.dto.out.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedBackOutputDto {
    private String comment;

    private int starPoint;

    private String userName;
}
