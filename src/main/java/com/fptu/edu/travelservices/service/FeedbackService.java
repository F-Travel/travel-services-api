package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.feedback.FeedbackInputDto;
import com.fptu.edu.travelservices.dto.out.feedback.FeedBackListReportOutputDto;

import java.util.List;

public interface FeedbackService {

    int saveFeedBack(FeedbackInputDto inputDto);

    void deleteFeedBack(int feedbackId);

    void reportFeedback(int feedbackId);

    void cancelReportFeedback(int feedbackId);

    List<FeedBackListReportOutputDto> getListReport();
}
