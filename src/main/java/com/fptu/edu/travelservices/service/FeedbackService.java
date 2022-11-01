package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.feedback.FeedbackInputDto;

public interface FeedbackService {

    int saveFeedBack(FeedbackInputDto inputDto);
}
