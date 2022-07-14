package com.example.hotelproject.services;

import com.example.hotelproject.exceptions.HumanIsCriminalException;
import com.example.hotelproject.models.HotelUser;
import com.example.hotelproject.models.Staff;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class SecurityCheckService {

    //do it asynchron

    public boolean isCriminal(Staff staff) {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);

        if(Objects.nonNull(response.getBody())) {
            if(staff.getFullName().contains(response.getBody())) {
                throw new HumanIsCriminalException("potential criminal", null);
            }
        }

        return false;
    }

    public boolean isCriminal(HotelUser user) {

        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
                = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);

        if(Objects.nonNull(response.getBody())) {
            if(user.getName().contains(response.getBody())) {
                throw new HumanIsCriminalException("potential criminal", null);
            }
        }

        return false;
    }
}
