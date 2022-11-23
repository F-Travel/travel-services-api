package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.dto.result.HotelPropertiesList;
import com.fptu.edu.travelservices.entity.HotelProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface HotelPropertiesRepository extends JpaRepository<HotelProperties, Integer> {
    @Query(value = "SELECT \n" +
            "hpt.id as propertiesTypeId,\n" +
            "hp.properties_type as propertiesType,\n" +
            "hpt.properties_type_nm as propertiesTypeName\n" +
            "FROM hotel_properties as hp\n" +
            "INNER JOIN hotel_properties_type as hpt\n" +
            "ON hp.properties_type_id = hpt.id\n" +
            "WHERE hp.hotel_id = ?1", nativeQuery = true)
    List<HotelPropertiesList> getListHotelProperties(int id);
}
