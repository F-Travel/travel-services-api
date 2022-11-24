package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.dto.result.BookingList;
import com.fptu.edu.travelservices.dto.result.CityTopList;
import com.fptu.edu.travelservices.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value = "SELECT\n" +
            "c.id as id,\n" +
            "c.city_image as cityImage,\n" +
            "c.city_name as cityName,\n" +
            "COUNT(c.id) as total\n" +
            "FROM city as c\n" +
            "inner Join hotel as h\n" +
            "ON c.id = h.city_id\n" +
            "inner Join room_type as rt\n" +
            "ON h.id = rt.hotel_id\n" +
            "inner Join booking_room as br\n" +
            "ON rt.id = br.room_id\n" +
            "inner Join booking as b\n" +
            "ON br.booking_id = b.id\n" +
            "GROUP BY id, cityImage, cityName \n" +
            "order by total desc\n" +
            "limit 9", nativeQuery = true)
    List<CityTopList> getTopListCity();
}
