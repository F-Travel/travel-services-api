package com.fptu.edu.travelservices.service;

import com.fptu.edu.travelservices.dto.in.booking.BookingRoomInputDto;
import com.fptu.edu.travelservices.dto.out.booking.*;

import java.util.List;

public interface BookingService {

    int saveRequestBooking(BookingRoomInputDto inputDto);

    List<BookingRoomListOutputDto> getListBooking(int roomId);

    List<HistoryBookingOutputDto> getListHistoryBooking(int userId);

    List<BookingMonthlyRevenueListOutputDto> getListMonthlyRevenue(int hotelId, String startDate, String endDate);

    List<BookingMonthlyRevenueReportOutputDto> getListMonthlyRevenueReport(int hotelId, String startDate, String endDate);

    List<DebtMonthOutputDto> getListMonthlyDebt(int hotelId, String startDate, String endDate);

    void approveBooking(int bookingId);

    void rejectBooking(int bookingId);
}
