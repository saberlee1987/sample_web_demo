package com.saber.sample_web_demo.services;

import com.saber.sample_web_demo.dto.PersonDto;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    public List<PersonDto> getAllPersons() {
        List<PersonDto> persons = new ArrayList<>();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            long id = random.nextLong(1000) + 1;
            persons.add(PersonDto.builder()
                    .id(id)
                    .firstname("firstName_" + id)
                    .lastname("lastName_" + id)
                    .age(random.nextInt(100) + 1)
                    .email("test@yahooo.com")
                    .mobile("09" + random.nextInt(111111111, 999999999))
                    .build());

        }

        return persons;
    }
}
