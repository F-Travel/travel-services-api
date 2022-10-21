package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.entity.RoomProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoomPropertiesRepository extends JpaRepository<RoomProperties,Integer> {
}
