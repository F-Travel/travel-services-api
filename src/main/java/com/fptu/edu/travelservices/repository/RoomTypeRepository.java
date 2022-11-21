package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.dto.result.RoomTypeList;
import com.fptu.edu.travelservices.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

    @Query(value = "SELECT Max(id) as roomId FROM room_type", nativeQuery = true)
    int getFistId();

    @Query(value = "SELECT \n" +
            "rt.id as roomTypeId,\n" +
            "rt.image as image,\n" +
            "rt.type_room_name as typeRoomName,\n" +
            "rt.room_area as roomArea,\n" +
            "rt.price as price,\n" +
            "rt.number_people as numberPeople\n" +
            "FROM room_type as rt\n" +
            "WHERE rt.hotel_id = ?1", nativeQuery = true)
    List<RoomTypeList> getListRoomType(int hotelId);
}
