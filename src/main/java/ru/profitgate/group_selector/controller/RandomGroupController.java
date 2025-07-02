package ru.profitgate.group_selector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomGroupController {

    @Autowired
    TgProperties tgProperties;

    volatile int counter = 1;

    @GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponse> getRandomGroup() {
        var groups = tgProperties.getGroups();
        var group = groups.get(counter % groups.size());
        counter++;
        if (counter == Integer.MAX_VALUE) counter = 0;
        return new ResponseEntity<>(new GroupResponse(group), HttpStatus.OK);
    }
}
