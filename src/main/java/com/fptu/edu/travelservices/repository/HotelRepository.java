package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
    @Modifying
    @Query(value = "insert into hotels(hotels.title, hotels.address, hotels.street, hotels.province , hotels.district, " +
            "hotels.city, hotels.latitude, hotels.longitude, hotels.phone, hotels.description,hotels.owner_id)\n" +
            "value(?1, ?2, ?3, ?4, ?5,?6, ?7, ?8, ?9,?10,?11);", nativeQuery = true)
    void createHotel(String title,String address, String street, String province, String district,
                     String city, String latitude, String longitude, String phone, String description,
                     int ownerId);

    @Query(value = "SELECT Max(id) as hotelId FROM hotel", nativeQuery = true)
    int getFistIdHotel();
}
