package com.example.myboot.service.impl;

import com.example.myboot.model.Massage;
import com.example.myboot.mysqlModel.User;
import com.example.myboot.repositoty.UserRepository;
import com.example.myboot.service.RestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
@Service("restService")
public class RestServiceImpl implements RestService {

    private final ConcurrentHashMap<String,Massage> concurrentHashMap
            =new ConcurrentHashMap<>();

    private static AtomicLong atomicLong = new AtomicLong();

    @Resource
    private UserRepository userRepository;

    @Override
    public void update(Massage massage,String id) {
        massage = new Massage();
        massage.setName("hh");
        massage.setCount("234");
        if(concurrentHashMap.containsKey(id)){
            concurrentHashMap.put(id,massage);
        }
    }

    @Override
    public Massage getById(String id) {
        if(concurrentHashMap.containsKey(id)){
            concurrentHashMap.get(id);
        }
        return null;
    }

    @Override
    public List<Massage> findAll() {
        //map的遍历方法1
        List<Massage> massageList = new ArrayList<>();
        if(concurrentHashMap.size()!=0){
            //map的遍历方法1
            Set<Massage> set
                    = (Set<Massage>)concurrentHashMap.values();
            Iterator iterator = set.iterator();
            if(iterator.hasNext()){
                massageList.add((Massage) iterator.next());
            }
            //map的遍历方法2
            /*Set<Map.Entry<Long,Massage>> entrySet
                    = concurrentHashMap.entrySet();
            for (Map.Entry<Long,Massage> entry:entrySet){
                massageList.add(entry.getValue());
            }*/


        }
        Massage massage = new Massage();
        List<User> all = userRepository.findALL();
        massage.setUserList(all);
        massageList.add(massage);
        return massageList;
    }

    @Override
    public Massage save(Massage massage) {
        Long id = atomicLong.incrementAndGet();
        concurrentHashMap.put(String.valueOf(id),massage);
        return concurrentHashMap.get(String.valueOf(id));
    }

    @Override
    public void delete(String id) {
        concurrentHashMap.remove(id);
    }
}
