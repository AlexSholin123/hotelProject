package com.example.hotelproject.services;

import com.example.hotelproject.models.HotelUser;
import com.example.hotelproject.models.Staff;
import org.springframework.stereotype.Service;

@Service
public class CallPoliceService {

    public Staff callPolice (Staff staff) {
        System.out.println("call police");
        return staff;
    }

    public HotelUser callPolice (HotelUser user) {
        System.out.println("call police");
        return user;
    }

}
