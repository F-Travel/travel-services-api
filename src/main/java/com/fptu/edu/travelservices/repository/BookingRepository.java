package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.dto.result.*;
import com.fptu.edu.travelservices.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query(value = "SELECT Max(id) as bookingId FROM booking", nativeQuery = true)
    int getFistIdBooking();

    @Query(value = "SELECT\n" +
            "rt.type_room_name as roomName,\n" +
            "DATE_FORMAT(b.check_in, '%d/%m/%Y') as checkIn,\n" +
            "DATE_FORMAT(b.check_out, '%d/%m/%Y') as checkOut,\n" +
            "b.user_booking as userBooking,\n" +
            "b.email as email,\n" +
            "CONVERT(b.phone, CHAR(11)) as phone,\n" +
            "b.total_price as totalPrice,\n" +
            "DATE_FORMAT(b.create_time, '%d/%m/%Y') as dateBooking,\n" +
            "b.booking_status as bookingStatus\n" +
            "FROM booking as b\n" +
            "INNER JOIN booking_room as br\n" +
            "ON b.id = br.booking_id\n" +
            "INNER JOIN room_type as rt\n" +
            "ON br.room_id = rt.id\n" +
            "INNER JOIN hotel as h\n" +
            "ON h.id= rt.hotel_id\n" +
            "WHERE b.booking_status = 'booking waiting approve'\n" +
            "and rt.id = ?1", nativeQuery = true)
    List<BookingList> getListBooking(int hotelId);


    @Query(value = "SELECT DISTINCT\n" +
            "ht.hotel_name as hotelName,\n" +
            "ht.image as image,\n" +
            "ht.address as address,\n" +
            "b.booking_status as bookingStatus\n" +
            "FROM booking as b\n" +
            "INNER JOIN booking_room as br\n" +
            "ON b.id = br.booking_id\n" +
            "INNER JOIN room_type as rt\n" +
            "ON br.room_id = rt.id\n" +
            "INNER JOIN hotel as ht\n" +
            "ON rt.hotel_id = ht.id\n" +
            "WHERE b.user_id = ?1", nativeQuery = true)
    List<HistoryBooking> getHistoryBooking(int userId);

    @Query(value = "SELECT DISTINCT\n" +
            "rt.type_room_name as roomName\n" +
            "FROM booking as b\n" +
            "INNER JOIN booking_room as br\n" +
            "ON b.id = br.booking_id\n" +
            "INNER JOIN room_type as rt\n" +
            "ON br.room_id = rt.id\n" +
            "INNER JOIN hotel as ht\n" +
            "ON rt.hotel_id = ht.id\n" +
            "WHERE b.user_id = ?1", nativeQuery = true)
    List<RoomHistoryBooking> getRoomHistoryBooking(int userId);

    @Query(value = "SELECT DISTINCT \n" +
            "DISTINCT bk.id as numberBooking,\n" +
            "total_price as totalAmount,\n" +
            "DATE_FORMAT(bk.create_time, '%d/%m/%Y') createDate\n" +
            "FROM booking as bk\n" +
            "INNER JOIN booking_room as br\n" +
            "ON bk.id = br.booking_id\n" +
            "INNER JOIN room_type as rt\n" +
            "ON br.room_id = rt.id\n" +
            "INNER JOIN hotel as ht\n" +
            "ON rt.hotel_id = ht.id\n" +
            "WHERE ht.id = ?1\n" +
            "AND DATE_FORMAT(bk.create_time, '%d/%m/%Y') >= ?2\n" +
            "AND DATE_FORMAT(bk.create_time, '%d/%m/%Y') <= ?3", nativeQuery = true)
    List<MonthlyRevenueList> getMonthlyRevenue(int hotelId, String startDate, String endDate);

    @Query(value = "SELECT DISTINCT \n" +
            "DISTINCT bk.id as numberBooking,\n" +
            "total_price as totalAmount,\n" +
            "DATE_FORMAT(bk.create_time, '%d/%m/%Y') createDate\n" +
            "FROM booking as bk\n" +
            "INNER JOIN booking_room as br\n" +
            "ON bk.id = br.booking_id\n" +
            "INNER JOIN room_type as rt\n" +
            "ON br.room_id = rt.id\n" +
            "INNER JOIN hotel as ht\n" +
            "ON rt.hotel_id = ht.id\n" +
            "WHERE\n" +
            "DATE_FORMAT(bk.create_time, '%d/%m/%Y') >= ?1\n" +
            "AND DATE_FORMAT(bk.create_time, '%d/%m/%Y') <= ?2", nativeQuery = true)
    List<MonthlyRevenueList> getMonthlyRevenueAll(String startDate, String endDate);

    @Query(value = "SELECT DISTINCT \n" +
            "DISTINCT bk.id as id,\n" +
            "bk.user_booking as userBooking,\n" +
            "bk.phone as phone,\n" +
            "total_price as totalAmount,\n" +
            "DATE_FORMAT(bk.create_time, '%d/%m/%Y') createDate\n" +
            "FROM booking as bk\n" +
            "INNER JOIN booking_room as br\n" +
            "ON bk.id = br.booking_id\n" +
            "INNER JOIN room_type as rt\n" +
            "ON br.room_id = rt.id\n" +
            "INNER JOIN hotel as ht\n" +
            "ON rt.hotel_id = ht.id\n" +
            "WHERE ht.id = ?1\n" +
            "AND DATE_FORMAT(bk.create_time, '%d/%m/%Y') >= ?2\n" +
            "AND DATE_FORMAT(bk.create_time, '%d/%m/%Y') <= ?3\n" +
            "AND booking_status = 'booking approved'\n" +
            "order by createDate DESC", nativeQuery = true)
    List<MonthlyRevenueReport> getMonthlyRevenueListReport(int hotelId, String startDate, String endDate);

    @Query(value = "SELECT DISTINCT \n" +
            "DISTINCT bk.id as id,\n" +
            "bk.user_booking as userBooking,\n" +
            "bk.phone as phone,\n" +
            "total_price as totalAmount,\n" +
            "DATE_FORMAT(bk.create_time, '%d/%m/%Y') createDate\n" +
            "FROM booking as bk\n" +
            "INNER JOIN booking_room as br\n" +
            "ON bk.id = br.booking_id\n" +
            "INNER JOIN room_type as rt\n" +
            "ON br.room_id = rt.id\n" +
            "INNER JOIN hotel as ht\n" +
            "ON rt.hotel_id = ht.id\n" +
            "WHERE \n" +
            "DATE_FORMAT(bk.create_time, '%d/%m/%Y') >= ?1\n" +
            "AND DATE_FORMAT(bk.create_time, '%d/%m/%Y') <= ?2\n" +
            "AND booking_status = 'booking approved'\n" +
            "order by createDate DESC", nativeQuery = true)
    List<MonthlyRevenueReport> getMonthlyRevenueListReportAll(String startDate, String endDate);

    @Query(value = "SELECT DISTINCT\n" +
            "(select \n" +
            "sum(bill.total_amount)\n" +
            "From bill\n" +
            "where bill.payment_method = 'vnpay'\n" +
            ") as vnpay,\n" +
            "(select \n" +
            "sum(bill.total_amount)\n" +
            "From bill\n" +
            "where bill.payment_method = 'cash'\n" +
            ") as cash,\n" +
            "sum(total_price*0.05) as paymentServices\n" +
            "FROM booking as bk\n" +
            "INNER JOIN booking_room as br\n" +
            "ON bk.id = br.booking_id\n" +
            "INNER JOIN bill as bi\n" +
            "ON bk.id = bi.booking_id\n" +
            "INNER JOIN room_type as rt\n" +
            "ON br.room_id = rt.id\n" +
            "INNER JOIN hotel as ht\n" +
            "ON rt.hotel_id = ht.id\n" +
            "WHERE ht.id = ?1\n" +
            "AND DATE_FORMAT(bk.create_time, '%d/%m/%Y') >= ?2\n" +
            "AND DATE_FORMAT(bk.create_time, '%d/%m/%Y') <= ?3", nativeQuery = true)
    List<MonthlyDebtReport> getDebt(int hotelId, String startDate, String endDate);

    @Transactional
    @Modifying
    @Query(value = "UPDATE booking\n" +
            "SET booking_status = ?1\n" +
            "WHERE id = ?2", nativeQuery = true)
    void updateStatusBooking(String bookingStatus, int id);
}
