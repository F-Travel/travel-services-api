package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.dto.in.feedback.FeedbackInputDto;
import com.fptu.edu.travelservices.entity.Feedback;
import com.fptu.edu.travelservices.repository.FeedBackRepository;
import com.fptu.edu.travelservices.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImp implements FeedbackService {

    @Autowired
    private FeedBackRepository feedbackRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public int saveFeedBack(FeedbackInputDto inputDto) {
        Feedback feedback = new Feedback();
        feedback.setStarPoint(Integer.parseInt(inputDto.getStarPoint()));
        feedback.setComment(inputDto.getComment());
        feedback.setUserId(Long.parseLong(inputDto.getUserId()));
        feedback.setHotelId(Integer.parseInt(inputDto.getHotelId()));

        /*save feedback into DB*/
        feedbackRepository.save(feedback);

        int feedBackId = feedbackRepository.getFirstFeedBacId();

        return feedBackId;
    }
}
