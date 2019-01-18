package com.example.elasticsearch.retrievedata.load;

import com.example.elasticsearch.retrievedata.model.User;
import com.example.elasticsearch.retrievedata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ESDataLoader {


    @Autowired
    ElasticsearchOperations operations;

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    @Transactional
    public void loadAll(){

        operations.putMapping(User.class);
        System.out.println("Loading Data");
        for (User user:getData()) {
            userRepository.save(user);
        }
        System.out.printf("Loading Completed");

    }

    private List<User> getData() {
        List<User> userses = new ArrayList<>();
        userses.add(new User("Ajay",123L, "Accounting", 12000L));
        userses.add(new User("Jaga",1234L, "Finance", 22000L));
        userses.add(new User("Thiru",1235L, "Accounting", 12000L));
        return userses;
    }
}

