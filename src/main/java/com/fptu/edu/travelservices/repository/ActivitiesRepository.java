package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.entity.Activities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ActivitiesRepository extends JpaRepository<Activities, Integer> {
}
