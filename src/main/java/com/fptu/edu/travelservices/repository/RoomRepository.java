package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.entity.Room_Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoomRepository extends JpaRepository<Room_Type, Integer> {
    /*@Query(value = "SELECT Max(id) as roomId FROM room;", nativeQuery = true)
    int getFistId();*/

    @Query(value = "SELECT Max(id) as roomId FROM room", nativeQuery = true)
    int getFistId();
}
