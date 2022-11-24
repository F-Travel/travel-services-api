package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.bill.BillAddNewInputDto;

public interface BillService {
    void saveBill(BillAddNewInputDto bill);
}
