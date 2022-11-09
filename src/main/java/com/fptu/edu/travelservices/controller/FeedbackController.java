package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.request.feedback.FeedbackRequest;
import com.fptu.edu.travelservices.controller.response.feedback.FeedBackListReportResponse;
import com.fptu.edu.travelservices.dto.in.feedback.FeedbackInputDto;
import com.fptu.edu.travelservices.dto.out.feedback.FeedBackListReportOutputDto;
import com.fptu.edu.travelservices.service.FeedbackService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

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
    public ResponseEntity<?> deleteFeedback(@PathVariable String feedbackId) {

        int id = Integer.parseInt(feedbackId);

        /*delete feedback*/
        feedbackService.deleteFeedBack(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/report-feedback/{feedbackId}")
    public ResponseEntity<?> reportFeedback(@PathVariable String feedbackId) {

        int id = Integer.parseInt(feedbackId);

        /*report feedback*/
        feedbackService.reportFeedback(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/list-report")
    public ResponseEntity<?> getListReportFeedback() {

        List<FeedBackListReportOutputDto> outputDtos = feedbackService.getListReport();

        /*mapping data*/
        Type listType = new TypeToken<List<FeedBackListReportResponse>>(){}.getType();
        List<FeedBackListReportResponse> feedBackResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(feedBackResponses);
    }

    @PutMapping("/cancel-report/{feedbackId}")
    public ResponseEntity<?> cancelReportFeedback(@PathVariable String feedbackId) {

        int id = Integer.parseInt(feedbackId);

        /*report feedback*/
        feedbackService.cancelReportFeedback(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
