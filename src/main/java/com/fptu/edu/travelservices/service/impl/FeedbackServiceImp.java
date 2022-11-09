package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.dto.in.feedback.FeedbackInputDto;
import com.fptu.edu.travelservices.dto.out.feedback.FeedBackListReportOutputDto;
import com.fptu.edu.travelservices.dto.out.user.UserOutputDto;
import com.fptu.edu.travelservices.dto.result.FeedBackListReport;
import com.fptu.edu.travelservices.entity.Feedback;
import com.fptu.edu.travelservices.repository.FeedBackRepository;
import com.fptu.edu.travelservices.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedbackServiceImp implements FeedbackService {

    /*init status feedback*/
    public static final String ACTIVATE = "activate";

    /*init status feedback-reported*/
    public static final String REPORTED = "reported";

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
        feedback.setStatusFeedback(ACTIVATE);

        /*save feedback into DB*/
        feedbackRepository.save(feedback);

        int feedBackId = feedbackRepository.getFirstFeedBacId();

        return feedBackId;
    }

    @Override
    public void deleteFeedBack(int feedBackId) {
        /*delete hard feedback in DB*/
        feedbackRepository.deleteById(feedBackId);
    }

    @Override
    public void reportFeedback(int feedbackId) {
        /*change feedback status is reported*/
        feedbackRepository.reportFeedBack(REPORTED, feedbackId);
    }

    @Override
    public void cancelReportFeedback(int feedbackId) {
        /*change feedback status is activate*/
        feedbackRepository.reportFeedBack(ACTIVATE, feedbackId);
    }

    @Override
    public List<FeedBackListReportOutputDto> getListReport() {

        List<FeedBackListReport> feedbacks = feedbackRepository.getListFeedBackReport();

        /*filter user activate*/
        List<FeedBackListReportOutputDto> outputDtos =  feedbacks.stream()
                .filter(item -> item.getStatusFeedback().equals("reported"))
                    .map(user -> { FeedBackListReportOutputDto result = mapper
                        .map(user, FeedBackListReportOutputDto.class);
                    return result;
                }).collect(Collectors.toList());

        return outputDtos;
    }
}
