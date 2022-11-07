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
@RequestMapping("/api/feedback")
public class FeedbackController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/add-new")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<?> addFeedbackByUser(@RequestBody FeedbackRequest request) {

        /*mapping form request register hotel*/
        FeedbackInputDto feedbackInputDto = mapper.map(request, FeedbackInputDto.class);

        /*insert feedback by user*/
        feedbackService.saveFeedBack(feedbackInputDto);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{feedbackId}")
    public ResponseEntity<?> deleteFeedback(@PathVariable String hotelId) {
        //To do
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PutMapping("/delete/{feedbackId}")
    public ResponseEntity<?> reportFeedback(@PathVariable String hotelId) {
        //To do
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/list-report")
    public ResponseEntity<?> getListReportFeedback(@PathVariable String hotelId) {
        //To do
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping("/cancel-report/{feedbackId}")
    public ResponseEntity<?> cancelReportFeedback(@PathVariable String hotelId) {
        //To do
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
}
