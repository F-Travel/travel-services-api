package com.fptu.edu.travelservices.service.impl;

import com.fptu.edu.travelservices.common.DateCommon;
import com.fptu.edu.travelservices.dto.in.bill.BillAddNewInputDto;
import com.fptu.edu.travelservices.dto.out.bill.BillHistoryListOutputDto;
import com.fptu.edu.travelservices.dto.result.BillHistoryList;
import com.fptu.edu.travelservices.entity.Bill;
import com.fptu.edu.travelservices.repository.BillRepository;
import com.fptu.edu.travelservices.service.BillService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    /*status bill waiting payment*/
    public static final String BILL_WAITING_PAYMENT = "bill waiting payment";

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private DateCommon dateCommon;

    @Override
    public void saveBill(BillAddNewInputDto bill) {

        Bill bills = new Bill();

        bills.setPaymentMethod(bill.getPaymentMethod());
        bills.setExternalInvoice(bill.getExternalInvoice());
        bills.setExternalTransaction(bill.getExternalTransaction());
        bills.setTotalAmount(Float.parseFloat(bill.getTotalAmount()));
        bills.setStatusBill(BILL_WAITING_PAYMENT);
        bills.setBookingId(Integer.parseInt(bill.getBookingId()));
        bills.setCreateBy("User");
        bills.setCreateTime(dateCommon.getDate());
        bills.setUpdatedBy("User");
        bills.setUpdatedTime(dateCommon.getDate());

        billRepository.save(bills);

    }

    @Override
    public List<BillHistoryListOutputDto> getListBillHistory(int userId) {

        List<BillHistoryList> billHistoryLists = billRepository.getHistoryBill(userId);

        Type listType = new TypeToken<List<BillHistoryListOutputDto>>(){}.getType();
        List<BillHistoryListOutputDto> billHistoryListOutputDtos = mapper.map(billHistoryLists , listType);

        return billHistoryListOutputDtos;
    }
}
