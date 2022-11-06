package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.dto.result.RoomPropertiesList;
import com.fptu.edu.travelservices.entity.RoomProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoomPropertiesRepository extends JpaRepository<RoomProperties,Integer> {

    @Query(value = "SELECT \n" +
            "rp.property_name as propertiesName,\n" +
            "rpt.properties_type_name as propertiesTypeName\n" +
            "FROM room_properties as rp\n" +
            "INNER JOIN room_properties_type as rpt\n" +
            "ON rp.properties_type_id = rpt.id\n" +
            "WHERE rp.room_type_id = ?1", nativeQuery = true)
    List<RoomPropertiesList> getListRoomProperties(int roomTypeId);
}
