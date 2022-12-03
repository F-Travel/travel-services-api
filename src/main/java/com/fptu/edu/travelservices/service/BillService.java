package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.bill.BillAddNewInputDto;
import com.fptu.edu.travelservices.dto.in.bill.BillUpateInfoInputDto;
import com.fptu.edu.travelservices.dto.out.bill.BillHistoryListOutputDto;

import java.util.List;

public interface BillService {
    void saveBill(BillAddNewInputDto bill);

    void saveBillInfo(BillUpateInfoInputDto inputDto);

    List<BillHistoryListOutputDto> getListBillHistory(int userId);
}
