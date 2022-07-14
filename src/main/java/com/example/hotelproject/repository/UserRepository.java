package com.example.hotelproject.repository;

import com.example.hotelproject.models.HotelUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<HotelUser,Long> {

}
