package com.fptu.edu.travelservices.controller;

import com.fptu.edu.travelservices.controller.response.bill.BillHistoryListResponse;
import com.fptu.edu.travelservices.dto.out.bill.BillHistoryListOutputDto;
import com.fptu.edu.travelservices.service.BillService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BillService billService;

    @GetMapping("/history/{userId}")
    /*@PreAuthorize("hasRole('MODERATOR')")*/
    public ResponseEntity<?> getListRequestBooking(@PathVariable String userId) {

        int id = Integer.parseInt(userId);

        /*search list hotel*/
        List<BillHistoryListOutputDto> outputDtos = billService.getListBillHistory(id);

        Type listType = new TypeToken<List<BillHistoryListResponse>>(){}.getType();
        List<BillHistoryListResponse> billHistoryListResponses = mapper.map(outputDtos , listType);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(billHistoryListResponses);
    }
}
