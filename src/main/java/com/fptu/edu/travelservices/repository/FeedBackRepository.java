package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.dto.result.FeedBack;
import com.fptu.edu.travelservices.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
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
            "ON f.id = u.id\n" +
            "WHERE f.hotel_id = ?1", nativeQuery = true)
    List<FeedBack> getListFeedBack(int id);

    @Query(value = "SELECT Max(id) as feedBackId FROM feedback", nativeQuery = true)
    int getFirstFeedBacId();
}
