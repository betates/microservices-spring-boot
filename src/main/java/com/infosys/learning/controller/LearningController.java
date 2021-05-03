package com.infosys.learning.controller;

import com.infosys.learning.dto.*;
import com.infosys.learning.model.*;
import com.infosys.learning.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class LearningController {

    @Autowired
    LearningService learningService;

    @GetMapping(value = "/getpersonname")
    public String getPersonName(@RequestParam(value = "gender", defaultValue = "gender")String gender) {

        return learningService.getName(gender);

    }

    @GetMapping(value = "/getpersonnamev2")
    public Person getPersonNameV2(@RequestParam(value = "gender", defaultValue = "gender")String gender) {

        return learningService.getNameV2(gender);

    }

    @PostMapping(value = "/getpersonnamev3", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getPersonNameV3(@RequestBody(required = true) Person person) {

        return learningService.getNameV3(person.getName());

    }

    @PostMapping(value = "/getperson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonResponse getPerson(@RequestBody(required = true) PersonRequest person) {

        return LearningService.getPerson(person.getName(), person.getYeaOfBirth());
    }

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String register(@RequestBody(required = true) UserRequest userRequest) {

        return LearningService.register(userRequest);

    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public User login(@RequestBody(required = true) UserRequest userRequest) {
        return learningService.login(userRequest);
    }

}
