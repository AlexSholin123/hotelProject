package com.example.hotelproject.services;

import com.example.hotelproject.exceptions.HumanIsCriminalException;
import com.example.hotelproject.models.Staff;
import com.example.hotelproject.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    SecurityCheckService securityCheckService;

    @Autowired
    CallPoliceService callPoliceService;

    public Optional<Staff> get(long id) {
        return staffRepository.findById(id);
    }

    //exceptions should not be used in business logic, just example
    //consider to use exception handler
    public Staff add(Staff staff) {
        try  {
            securityCheckService.isCriminal(staff);
        } catch (HumanIsCriminalException e) {
            callPoliceService.callPolice(staff);
        }

        return staffRepository.save(staff);
    }

    public void edit(long id, Staff editedStaff) {
        editedStaff.setId(id);
        staffRepository.save(editedStaff);
    }

    public void delete(long id) {
        staffRepository.deleteById(id);
    }
}
