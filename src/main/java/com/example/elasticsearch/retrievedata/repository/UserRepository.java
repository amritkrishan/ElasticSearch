package com.example.elasticsearch.retrievedata.repository;

import com.example.elasticsearch.retrievedata.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User,Long> {

    List<User> findByName(String text);

    List<User> findBySalary(Long salary);

}
