package com.example.myboot.service;

import com.example.myboot.model.Massage;

import java.util.List;

public interface RestService {
     void update(Massage massage,String id);
     Massage getById(String id);
     List<Massage> findAll();
     Massage save(Massage massage);
     void delete(String id);

}
