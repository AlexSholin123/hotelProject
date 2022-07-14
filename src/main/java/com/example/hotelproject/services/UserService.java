package com.example.hotelproject.services;

import com.example.hotelproject.exceptions.HumanIsCriminalException;
import com.example.hotelproject.models.HotelUser;
import com.example.hotelproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityCheckService securityCheckService;

    @Autowired
    private CallPoliceService callPoliceService;

    public Optional<HotelUser> get(long id) {
        return userRepository.findById(id);
    }

    public HotelUser add(HotelUser user) {
        try  {
            securityCheckService.isCriminal(user);
        } catch (HumanIsCriminalException e) {
            callPoliceService.callPolice(user);
        }
        return userRepository.save(user);
    }

    public void edit(long id, HotelUser editedUser) {
        editedUser.setId(id);
        userRepository.save(editedUser);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }


}
