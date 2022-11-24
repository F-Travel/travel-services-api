package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.dto.result.BillHistoryList;
import com.fptu.edu.travelservices.dto.result.HistoryBooking;
import com.fptu.edu.travelservices.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BillRepository extends JpaRepository<Bill, Integer> {
    @Query(value = "SELECT DISTINCT\n" +
            "bi.id as id,\n" +
            "ht.hotel_name as hotelName,\n" +
            "bi.total_amount as totalAmount,\n" +
            "bi.payment_method as paymentMethod,\n" +
            "bi.status_bill as statusBill\n" +
            "FROM bill as bi\n" +
            "INNER JOIN booking as bk\n" +
            "ON bi.booking_id = bk.id\n" +
            "INNER JOIN booking_room as br\n" +
            "ON bk.id = br.booking_id\n" +
            "INNER JOIN room_type as rt\n" +
            "ON br.room_id = rt.id\n" +
            "INNER JOIN hotel as ht\n" +
            "ON rt.hotel_id = ht.id\n" +
            "WHERE bk.user_id = ?1", nativeQuery = true)
    List<BillHistoryList> getHistoryBill(int userId);
}
