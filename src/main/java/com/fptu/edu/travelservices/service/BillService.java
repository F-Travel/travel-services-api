package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.bill.BillAddNewInputDto;
import com.fptu.edu.travelservices.entity.Bill;

public interface BillService {
    void saveBill(BillAddNewInputDto bill);

}
