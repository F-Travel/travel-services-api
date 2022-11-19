package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.dto.result.FeedBack;
import com.fptu.edu.travelservices.dto.result.FeedBackListReport;
import com.fptu.edu.travelservices.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FeedBackRepository extends JpaRepository<Feedback, Integer> {
    @Query(value = "SELECT \n" +
            "f.comment as comment,\n" +
            "f.star_point as starPoint,\n" +
            "u.full_name as userName\n" +
            "FROM feedback as f\n" +
            "INNER JOIN user as u\n" +
            "ON f.user_id = u.id\n" +
            "WHERE f.hotel_id = ?1", nativeQuery = true)
    List<FeedBack> getListFeedBack(int id);

    @Query(value = "SELECT Max(id) as feedBackId FROM feedback", nativeQuery = true)
    int getFirstFeedBacId();

    @Transactional
    @Modifying
    @Query(value = "UPDATE feedback\n" +
            "SET status_feedback = ?1\n" +
            "WHERE id = ?2", nativeQuery = true)
    void reportFeedBack(String reportFeedBack, int id);

    @Query(value = "SELECT\n" +
            "f.id as id,\n" +
            "f.comment as comment,\n" +
            "f.user_id as userId,\n" +
            "u.full_name as fullName,\n" +
            "f.hotel_id as hotelId,\n" +
            "h.hotel_name as hotelName,\n" +
            "f.status_feedback as statusFeedback\n" +
            "FROM feedback as f\n" +
            "LEFT JOIN user as u\n" +
            "ON f.user_id = u.id\n" +
            "LEFT JOIN hotel as h\n" +
            "ON f.hotel_id = h.id", nativeQuery = true)
    List<FeedBackListReport> getListFeedBackReport();
}
