package com.fptu.edu.travelservices.repository;

import com.fptu.edu.travelservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user\n" +
            "SET \n" +
            "full_name = ?1,\n" +
            "address = ?2,\n" +
            "phone = ?3,\n" +
            "birthday = STR_TO_DATE(?4, '%d/%m/%Y'),\n" +
            "avatar = ?5\n" +
            "WHERE id = ?6", nativeQuery = true)
    void updateUser(String fullName,String address,
                    String phone, String birthday,
                    String avatar, long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE user\n" +
            "SET user_status = ?1\n" +
            "WHERE id = ?2", nativeQuery = true)
    void deleteUser(String userStatus, long id);
}
