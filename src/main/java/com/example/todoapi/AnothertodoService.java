package com.example.todoapi;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("/secondService")
public class AnothertodoService implements todoServiceInterface {
    @Override
    public String getAllData() {
        return "get all the todo of service 2";
    }
}
