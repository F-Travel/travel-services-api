package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.dto.result.HotelTopList;
import com.fptu.edu.travelservices.entity.Hotel;
import com.fptu.edu.travelservices.dto.result.HotelSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

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

    @Query(value = "SELECT COUNT(id) as hotelId FROM hotel WHERE id = ?1", nativeQuery = true)
    int getHotelId(int id);

    @Query(value = "SELECT\n" +
            "h.id as id,\n" +
            "h.hotel_name as hotelName,\n" +
            "h.address as address,\n" +
            "h.description as description,\n" +
            "h.image as image,\n" +
            "h.status_hotel as statusHotel,\n" +
            "h.phone as phone,\n" +
            "ROUND(AVG(f.star_point),1) as startPoint,\n" +
            "ROUND(AVG(rt.price),3) as price\n" +
            "FROM hotel as h\n" +
            "left Join feedback as f\n" +
            "ON h.id = f.hotel_id\n" +
            "left Join room_type as rt\n" +
            "ON h.id = rt.hotel_id\n" +
            "where\n" +
            "match (h.address, h.hotel_name, h.description)\n" +
            "against (?1)\n" +
            "GROUP BY h.id", nativeQuery = true)
    List<HotelSearch> searchHotel(String param);

    @Query(value = "SELECT\n" +
            "h.id as id,\n" +
            "h.hotel_name as hotelName,\n" +
            "h.address as address,\n" +
            "h.description as description,\n" +
            "h.image as image,\n" +
            "h.phone as phone,\n" +
            "AVG(f.star_point) as startPoint,\n" +
            "ROUND(AVG(rt.price),3) as price\n" +
            "FROM hotel as h\n" +
            "left Join feedback as f\n" +
            "ON h.id = f.hotel_id\n" +
            "left Join room_type as rt\n" +
            "ON h.id = rt.hotel_id\n" +
            "where\n" +
            "h.city_id = ?1\n" +
            "GROUP BY h.id", nativeQuery = true)
    List<HotelSearch> getHotelByCity(String cityId);

    @Query(value = "SELECT \n" +
            "hotel.id as id,\n" +
            "hotel.hotel_name as hotelName,\n" +
            "hotel.image as image\n" +
            "FROM hotel\n" +
            "limit 4", nativeQuery = true)
    List<HotelTopList> getHotelTopList();

    /*test merge*/
    @Transactional
    @Modifying
    @Query(value = "UPDATE hotel\n" +
            "SET status_hotel = ?1\n" +
            "WHERE id = ?2", nativeQuery = true)
    void updateStatusHotel(String hotelStatus, long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE hotel\n" +
            "SET hotel_name = ?1,\n" +
            "description = ?2,\n" +
            "address = ?3,\n" +
            "city_id = ?4,\n" +
            "phone = ?5,\n" +
            "image = ?6,\n" +
            "image1 = ?7,\n" +
            "image2 = ?8,\n" +
            "image3 = ?9,\n" +
            "image4 = ?10,\n" +
            "latitude = ?11,\n" +
            "longitude = ?12,\n" +
            "is_payment_card = ?13,\n" +
            "check_out_time = ?14,\n" +
            "check_in_time = ?15\n" +
            "WHERE id = ?16", nativeQuery = true)
    void updateHotel(String hotelName,String description,String address,String cityId,String phone
            ,String image,String image1,String image2,String image3,String image4,String latitude
            ,String longitude,int isPaymentCard,String checkOutTime,String checkInTime, int id);
}
