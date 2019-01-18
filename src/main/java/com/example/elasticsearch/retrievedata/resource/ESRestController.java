package com.example.elasticsearch.retrievedata.resource;

import com.example.elasticsearch.retrievedata.model.User;
import com.example.elasticsearch.retrievedata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest/search")
public class ESRestController {


    @Autowired
    UserRepository usersRepository;

    @GetMapping(value = "/name/{text}")
    public List<User> searchName(@PathVariable final String text) {
        return usersRepository.findByName(text);
    }


    @GetMapping(value = "/salary/{salary}")
    public List<User> searchSalary(@PathVariable final Long salary) {
        return usersRepository.findBySalary(salary);
    }


    @GetMapping(value = "/all")
    public List<User> searchAll() {
        List<User> userList = new ArrayList<>();
        Iterable<User> userses = usersRepository.findAll();
        userses.forEach(userList::add);
        return userList;
    }
}
