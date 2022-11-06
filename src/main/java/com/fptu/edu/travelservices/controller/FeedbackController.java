package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.feedback.FeedbackRequest;
import com.fptu.edu.travelservices.dto.in.feedback.FeedbackInputDto;
import com.fptu.edu.travelservices.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FeedbackController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/feedback")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addFeedbackByUser(@RequestBody FeedbackRequest request) {

        /*mapping form request register hotel*/
        FeedbackInputDto feedbackInputDto = mapper.map(request, FeedbackInputDto.class);

        /*insert feedback by user*/
        feedbackService.saveFeedBack(feedbackInputDto);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
