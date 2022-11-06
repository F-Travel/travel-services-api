package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.entity.BookingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BookingRoomRepository extends JpaRepository<BookingRoom, Integer> {
}
