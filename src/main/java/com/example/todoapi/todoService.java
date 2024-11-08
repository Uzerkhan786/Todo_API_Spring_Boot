package com.example.todoapi;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("/firstService")
public class todoService implements todoServiceInterface {

    @Override
    public String getAllData() {
        return "get all the data of first todo service";
    }
}
